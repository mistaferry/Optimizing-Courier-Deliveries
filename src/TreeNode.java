public class TreeNode {
    public String clientName; //ключ
    public String address; //інші дані
    public TreeNode leftChild, rightChild;

    public void printNode() {
        //вивід даних вузла
        System.out.println("Клієнт - " + clientName);
        System.out.println("Адрес клієнта - " + address);
    }

    public String getAddress(){
        return address;
    }
}
