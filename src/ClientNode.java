public class ClientNode {
    public String clientName; //ключ
    public int arraySize = 2;
    public String[] address = new String[arraySize]; //інші дані
    public ClientNode leftChild, rightChild;

    public void printNode() {
        //вивід даних вузла
        System.out.println("Клієнт - " + clientName);
        System.out.println("Адрес клієнта - " + address[0]);
        System.out.println("Адрес найближчого магазину - " + address[1]);
    }

    public String getAddress(int index){
        if(index > 2 || index < 0 ){
            System.out.println("Інфомація не знайдена!");
        }else{
            return address[index];
        }
        return null;
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
