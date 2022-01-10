public class InlandSaltProvider implements SaltProvider {    
    
    static{
        SaltManager.registerProvider("InlandSalt", new InlandSaltProvider());
    }
 
    public Salt getSalt() {
	System.out.println("Excavator Digging Salt");
        return new InlandSalt();
    }
}