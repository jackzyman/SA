package models;

public class Medicine {
    private int idMedicine ;
    private String nameMedicine ;
    private String type ;
    private String dataOfReceive ;
    private String dataOfExp ;
    private int quantity ;
    private double price ;

    public Medicine(int idMedicine, String nameMedicine, String type, String dataOfReceive, String dataOfExp, int quantity, double price) {
        this.idMedicine = idMedicine;
        this.nameMedicine = nameMedicine;
        this.type = type;
        this.dataOfReceive = dataOfReceive;
        this.dataOfExp = dataOfExp;
        this.quantity = quantity;
        this.price = price;
    }
}
