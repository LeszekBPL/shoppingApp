package database;

import database.Favourites;
import database.Informations;
import database.ShoppingList;
import dto.InformationsDto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.service.spi.SessionFactoryServiceContributor;
import services.FoodFactsService;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Scanner;

public class DataProvider {
    Scanner scanner = new Scanner(System.in);
    FoodFactsService foodFactsService = new FoodFactsService();
    long barcode = scanner.nextLong();


    public Informations infProvider() {
        try {
            InformationsDto infDto = foodFactsService.food(barcode);
            System.out.println(infDto);
            Informations inf = new Informations(infDto.getCode(), infDto.getBrands(), infDto.getProduct_name(),
                    infDto.getCategories(), infDto.getCountries(), infDto.getStores(), infDto.getPurchase_places());
            return inf;
        } catch (IOException e) {
            e.printStackTrace();
            return null;


        }
    }

    public Favourites favProvider() {
        try {
            InformationsDto infDto = foodFactsService.food(barcode);
            System.out.println("podaj ocenę produktu od 1-5");
            int rate = scanner.nextInt();
            Favourites fav = new Favourites(infDto.getProduct_name(), rate);
            System.out.println(fav);
            return fav;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }

    public ShoppingList shListProvider() {
        try {
            InformationsDto infDto = foodFactsService.food(barcode);
            System.out.println("podaj ilość");
            int amount= scanner.nextInt();
            ShoppingList shList=new ShoppingList(infDto.getProduct_name(),amount);
            return shList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<ShoppingList>getAll(){
        List<ShoppingList> result=new ArrayList<>();
        try(Session session= HibernateUtil.getSessionFactory().openSession();)
        {
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<ShoppingList> query= criteriaBuilder.createQuery(ShoppingList.class);
            Root<ShoppingList> table= query.from(ShoppingList.class);
            query.select(table);
            List<ShoppingList>list=session.createQuery(query).list();
            result.addAll(list);
        }catch (HibernateException he){
            System.err.println("getAll error");
            he.printStackTrace();
        }
        return result;
    }
    public void shoppingListToTxT(){
        List<ShoppingList> shoppingLists=getAll();
        try {
            PrintWriter writer=new PrintWriter("ShoppingList.txt");
            for (ShoppingList shoppingList:shoppingLists) {
                writer.printf("id=%d | name=%s | amount=%d\n",
                        shoppingList.getId(),
                        shoppingList.getName(),shoppingList.getAmount());}
            writer.close();

            }catch (FileNotFoundException fnf){
                fnf.printStackTrace();
        }

    }
}