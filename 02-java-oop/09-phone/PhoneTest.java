
class PhoneTest {
    public static void main(String[] args) {

        Galaxy s9 = new Galaxy ("S9", 50, "Verizon", "'Who's phone is ringing? Mine! Mine! Mine!'");
        IPhone i10 = new IPhone ("X", 100, "AT&T", "'Shot through the heart, and you're to blame!'");

        s9.displayInfo();
        System.out.println(s9.ring());
        System.out.println(s9.unlock());

        i10.displayInfo();
        System.out.println(i10.ring());
        System.out.println(i10.unlock());

    }

}