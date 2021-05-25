public class Tree {

    public TreeNode root; //перший вузол дерева

    public Tree() {
        root = null; //дерево пусте, вузлів немає
    }

    //шукаємо вузол за ключем(ім'я клієнта)
    public TreeNode findClient(String key) {
        TreeNode current = root; //починаємо з першого вузла
        while (!current.clientName.equals(key)) { //поки не знайшли бажаний ключ

            //вибираємо в яку сторону рухатися
            if (key.compareTo(current.clientName) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) { //якщо потомка немає
                return null;
            }
        }
        return current; //елемент знайдено
    }

    public void add(String key, String data) {
        //новий вузол
        TreeNode node = new TreeNode();
        node.clientName = key;
        node.address = data;

        //якщо корінь пустий
        if (root == null) {
            root = node;
        } else {
            //поточний вузол
            TreeNode cur = root;
            TreeNode parent;
            while (true) {
                parent = cur;
                //якщо назва йде раніше, то наступний вузол поміщаємо вліво
                if (key.compareTo(cur.clientName) < 0) {
                    cur = cur.leftChild;
                    if (cur == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    //в іншому випадку поміщаємо вправо
                    cur = cur.rightChild;
                    if (cur == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
}
