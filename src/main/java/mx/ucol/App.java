package mx.ucol;

public class App {
    public static void main(String[] args) {
        Drop drop = new Drop();
        Thread[] producer = new Thread[5];
        Thread[] consumer = new Thread[5];

        for(int i = 0; i < 5; i++){
            producer[i] = new Thread(new Producer(drop));
            producer[i].start();
            consumer[i] = new Thread(new Consumer(drop));
            consumer[i].start();
        }
    }
}
