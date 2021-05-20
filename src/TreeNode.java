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

    public void search() {
        //якщо вузол не = null то шукаємо зліва
        if (leftChild != null) {
            leftChild.search();
        }
        printNode();
        //якщо вузол не = null то шукаємо справа
        if (rightChild != null) {
            rightChild.search();
        }
    }
}
