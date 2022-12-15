import java.util.ArrayList;
import java.util.Objects;


class Q{
    String Qu;
    String op1;
    String op2;
    String op3;
    String op4;
    int ca;
    int index;
    Q(String Qu,String op1,String op2,String op3,String op4,int ca,int index){
        this.Qu = Qu;
        this.ca = ca;
        this.index=index;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
    }
}
public class Quiz {
    Quiz(){

    }
    static ArrayList<Q>   quiz = new ArrayList<>();
    static ArrayList<Integer>   val = new ArrayList<>();
    static ArrayList<Integer>   ans = new ArrayList<>();
    static int eval(){
        int res = 0;
        for(int i =0;i<5;i++){

            if(Objects.equals(ans.get(i), val.get(i))){
                res++;
            }
        }
        return res;
    }


    static int na(){
        int res = 0;
        for(int i =0;i<5;i++){

            if(val.get(i)==-1){
                res++;
            }
        }
        return res;
    }
    static int a(){
        int res = 0;
        for(int i =0;i<5;i++){

            if(val.get(i)!=-1){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ans.add(2);
        ans.add(1);
        ans.add(2);
        ans.add(1);
        ans.add(1);
        for(int i =0;i<5;i++){
            val.add(-1);
            quiz.add(new Q("Which is the most expensive crypto in the world?"," Ethereum","Bitcoin","Binance Coin","Yearn.Finance",1,1));
            quiz.add(new Q("Which of the following is most valued currency in the world ?","Dollar","Euro","Rupees","Swiss Franc",1,2));
            quiz.add(new Q("Which business man has earned the most in 2021?","Elon musk","Gautam Adani","Bernard Arnault & Family","Warren Buffett",1,3));
            quiz.add(new Q("Which country went to economic crisis in 2022?","Sri Lanka","Argentina","Venezuela","Russia",1,4));
            quiz.add(new Q("Which was worst financial disasters and recessions in history ? "," Great recession","The Great Depression"," The long Depression","1772 Credit Crisis",1,5));

        }
    }




}
