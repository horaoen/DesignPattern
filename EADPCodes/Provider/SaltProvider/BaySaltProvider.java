
public class BaySaltProvider implements SaltProvider {    
    
    /**
     * 去盐监司登记
     */
    static{
        SaltManager.registerProvider("BaySalt", new BaySaltProvider());
    }
 
    public Salt getSalt() {
        // 用太阳晒，把水份蒸发
	System.out.println("Suning make Salt");
        return new BaySalt();
    }    
 
}
