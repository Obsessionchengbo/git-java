package test;

class main {
    public static void main(String[] args) {

        ye ye = new ye() {
            @Override
            public void jiao() {
                super.jiao();
            }
        };
        ye.speak();
        System.out.println();
    }
}

public abstract class ye extends die{

    public void jiao(){

    }

    @Override
    public void speak(){
        System.out.println("我他妈是你爷");
    }
}
