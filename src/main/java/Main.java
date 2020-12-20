import database.DataProvider;
import database.Favourites;
import database.Informations;
import database.ShoppingList;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import util.HibernateUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("podaj kod kreskowy");
        DataProvider dataProvider = new DataProvider();
        Informations informations = dataProvider.infProvider();
        session.persist(informations);
        session.flush();
        System.out.println("1 dodad do Ulubionych");
        System.out.println("2 dodaj do listy zakupów");
        System.out.println("3 wyświetl listę zakupów");
        System.out.println("4 wyświetl ulubione");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case (1):
                Favourites favourites = dataProvider.favProvider();
                session.persist(favourites);
                session.flush();
                break;
            case (2):
                ShoppingList shoppingList = dataProvider.shListProvider();
                session.persist(shoppingList);
                session.flush();
                break;
            case (3):
                System.out.println(dataProvider.getAll());
                System.out.println("1 wyczyść listę zakupów");
                System.out.println("2 eksportuj listę do pliku");
                System.out.println("0  powrót");
                int option = scanner.nextInt();
                switch (option) {
                    case (1):
                        NativeQuery<ShoppingList> querySL = session.createNativeQuery("delete from ShoppingList", ShoppingList.class);
                        querySL.executeUpdate();
                        break;
                    case (2):
                        dataProvider.shoppingListToTxT();

                        break;
                    case (0):
                        return;
                }
                break;
            case (4):
                NativeQuery<Favourites> favouritesNativeQuery = session.createNativeQuery("select *freom Favourites", Favourites.class);
                favouritesNativeQuery.getResultList().forEach(System.out::println);
                System.out.println("1 wyczyść ulubione");
                System.out.println("0  powrót");
                int decission = scanner.nextInt();
                switch (decission) {
                    case (1):
                        NativeQuery<Favourites> querySL = session.createNativeQuery("delete from Favourites", Favourites.class);
                        querySL.executeUpdate();
                        break;

                    case (0):
                        return;
                }
                break;
        }


    }
}
