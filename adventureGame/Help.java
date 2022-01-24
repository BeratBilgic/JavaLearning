package adventureGame;

public class Help extends Location {

    Help(Player player) {
        super(player);
    }
    
    public boolean getLocation()
	{
		System.out.println("\n\nLOCATIONS");
		System.out.println("******************************************");
		System.out.println("1. Safehouse --> Your village , no enemies!");
		System.out.println("2. Cave --> There will be zombies!");
		System.out.println("3. Forest --> There will be vampires!");
		System.out.println("4. River --> There will be bears!");
		System.out.println("5. Shop --> You can buy stuff!");
		System.out.println("\nENEMIES");
		System.out.println("******************************************");
		System.out.println("1.Zombies <Encountered in the Cave from #1 to #3 --> Health:10, Damage:3, Money:4");
		System.out.println("2.Vampires <Encountered in the Forest from #1 to #3 --> Health:14, Damage:4, Money:7");
		System.out.println("3.Bears <Encountered near the River from #1 to #3 --> Health:20, Damage:7, Money:12");
		System.out.println("\nWEAPONS");
		System.out.println("******************************************");
		System.out.println("1. Stick <Player's default weapon> --> Damage +0, Money +0");
		System.out.println("2. Knife <Purchased in the Tool Store> --> Damage +2, Money 25");
		System.out.println("3. Sword <Purchased in the Tool Store> --> Damage +3, Money 35");
		System.out.println("4. Katana <Purchased in the Tool Store> --> Damage +7, Money 45");
		System.out.println("\nARMORS");
		System.out.println("******************************************");
		System.out.println("1. Light <Purchased in the Tool Store> --> Damage -1, Money 15");
		System.out.println("2. Medium <Purchased in the Tool Store> --> Damage -3, Money 25");
		System.out.println("3. Heavy <Purchased in the Tool Store> --> Damage -5, Money 40");
		System.out.println("\nMISSION");
		System.out.println("******************************************");
		System.out.println("1. Go to the Cave. Kill all the zombies .Gain FOOD item!");
		System.out.println("2. Go to the Forest. Kill all the vampires .Gain FIREWOOD item!");
		System.out.println("3. Go to the River. Kill all the bears .Gain WATER item!");	
		System.out.println("4. Return to the SAFEHOUSE and bring all the ITEMS to the village!!");

        return true;
	}
}
