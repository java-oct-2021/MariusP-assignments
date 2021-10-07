import java.sql.BatchUpdateException;

class BatTest {

    public static void main(String[] args) {

        Bat b = new Bat();
        
        b.AttackTown();
        b.AttackTown();
        b.AttackTown();


        b.EatHumans();
        b.EatHumans();

        b.Fly();
        b.Fly();


    }

}
