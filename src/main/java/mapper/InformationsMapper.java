package mapper;

import database.Favourites;
import database.Informations;
import dto.InformationsDto;

public class InformationsMapper {
    public static Informations mapInformationsDtoToInformations(InformationsDto dto){
        Informations informations=new Informations();
        informations.setCode(dto.getCode());
        informations.setBrands(dto.getBrands());
        informations.setProduct_name(dto.getProduct_name());
        informations.setCategories(dto.getCategories());
        informations.setCountries(dto.getCountries());
        informations.setStores(dto.getStores());
        informations.setPurchase_places(dto.getPurchase_places());
        return informations;
    }


}
