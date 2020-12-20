package dto;

public class InformationsDto {
    private long code;
    private String brands;
    private String product_name;
    private String categories;
    private String countries;
    private String stores;
    private String purchase_places;

    public InformationsDto(long code, String brands, String product_name, String categories, String countries, String stores, String purchase_places) {
        this.code = code;
        this.brands = brands;
        this.product_name = product_name;
        this.categories = categories;
        this.countries = countries;
        this.stores = stores;
        this.purchase_places = purchase_places;
    }

    @Override
    public String toString() {
        return "InformationsDto{" +
                "code=" + code +
                ", brands='" + brands + '\'' +
                ", product_name='" + product_name + '\'' +
                ", categories='" + categories + '\'' +
                ", countries='" + countries + '\'' +
                ", stores='" + stores + '\'' +
                ", purchase_places='" + purchase_places + '\'' +
                '}';
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores;
    }

    public String getPurchase_places() {
        return purchase_places;
    }

    public void setPurchase_places(String purchase_places) {
        this.purchase_places = purchase_places;
    }

}
