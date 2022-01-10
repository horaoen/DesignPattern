public class Demo{
 
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("InlandSaltProvider");
        Salt salt = SaltManager.getSalt("InlandSalt");
        salt.addIodine();

		Class.forName("BaySaltProvider");
        salt = SaltManager.getSalt("BaySalt");
        salt.addIodine();
    }
}
