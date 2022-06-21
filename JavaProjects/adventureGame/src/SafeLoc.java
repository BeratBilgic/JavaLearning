public abstract class SafeLoc extends Location{
    SafeLoc(Player player, String name) {
        super(player);
        this.name = name;
    }
    
    public boolean getLocation(){
        return true;
    }
}
