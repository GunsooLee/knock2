public class Main {

    public static void main(String[] args) {
        CustomerDatabase db = new CustomerDatabase();
        for (Customer c : db.getCustomers()) {
            System.out.println(c);
        }
    }

}
