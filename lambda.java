public class lambda {
    interface myLambda{
        // public void display(String s);
        public int add(int x, int y);
        public void display();
    }

    class demo{
        int temp = 10
        public void method1(){
            int count =1;
            myLambda ml =() ->{
                System.out.println("hello beti",temp++); // ye ho sakta h kyuki temp method ke baahar hai 
                System.out.println("hey prabhu ek baar"); //me yahan count++ ya count ko change nhi kar 
            };                                             // sakta kyuki wo labda function jis method ke andar h usme aata hai 
            ml.display();
        }
    }

    public static void main(String[] args){
        // myLambda m = () ->{
        //     System.out.println("ye mera lambda expression se aaya hai ");
        // };
        // m.display();
        // myLambda m = (s) ->{
        //     System.out.println(s);
        // };
        // m.display("Aur kit ja hai re ");
        myLambda m =(x,y) ->x+y;
    //    System.out.println(m.add(3,5));
        int r= m.add(3,4);
        System.out.println(r);

    }
}
