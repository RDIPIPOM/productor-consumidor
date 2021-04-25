package mx.ucol;

public class Drop {
    private String message;
    private boolean empty[] = {
            true, //buffer 1
            true, //buffer 2
            true, //buffer 3
            true, //buffer 4
            true, //buffer 5
            true, //buffer 6
            true, //buffer 7
            true, //buffer 8
            true, //buffer 9
            true //buffer 10
    };

    public synchronized String take() {
        while (empty[0] == true && empty[1] == true && empty[2] == true && empty[3] == true && empty[4] == true && empty[5] == true && empty[6] == true && empty[7] == true && empty[8] == true && empty[9] == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Someone interrupted this thread." + e);
            }
        }

        for (int i = 0; i < 10; i++){
            if (empty[i] == false){
                empty[i] = true;
                break;
            }
        }
        notifyAll();

        return message;
    }

    public synchronized void put(String message) {
        while (empty[0] == false && empty[1] == false && empty[2] == false && empty[3] == false && empty[4] == false && empty[5] == false && empty[6] == false && empty[7] == false && empty[8] == false && empty[9] == false) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        for (int i = 0; i < 10; i++){
            if (empty[i] == true){
                empty[i] = false;
                this.message = message;
                break;
            }
        }

        notifyAll();
    }
}
