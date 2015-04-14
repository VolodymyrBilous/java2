import java.util.Random;

    abstract class Creatures {
    	private double heigth;
    	private double weight;
    	private int legsCount;
    	
		public double getHeigth() {
			return heigth;
		}

		public void setHeigth(double heigth) {
			this.heigth = (double) ((int)(heigth*100))/100;
		}

		public double getWeight() {
			
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = (double) ((int)(weight*100))/100 ;
		}

		public int getLegsCount() {
			return legsCount;
		}

		public void setLegsCount(int legsCount) {
			this.legsCount = legsCount;
		}

		public Creatures(double heigth, double weight, int legsCount) {
			super();
			setHeigth(heigth);
			setWeight(weight);
			setLegsCount(legsCount);
		}

    }
    abstract class Animals extends Creatures implements Running {

		public Animals(double heigth, double weight, int legsCount) {
			super(heigth, weight, legsCount);
		}	
			
    	public String run() {
    		return "I can run";
    	}			   	
    }
    abstract class Birds extends Creatures implements LayingEggs {

		public Birds(double heigth, double weight, int legsCount) {
			super(heigth, weight, legsCount);
			// TODO Auto-generated constructor stub
		}
    	public String layEggs(){
    		return "I lay eggs";
    	}    	
    }
    
    interface WhoAmI {
    	public String Description();
    }
    interface Feeding {
    	public String eat();
    }
    interface Flying {
    	public String fly();
    } 
    interface Running {
    	public String run();
    }  
    interface LayingEggs {
    	public String layEggs();
    }    
    interface Hunting {
    	public String hunt();
    }    
    class Elefant extends Animals implements Feeding,Running,WhoAmI {
    	public static int lCount;
    	private int elefantCount=0;
    	
    	public String eat(){
    		return "I can eat";
    	}

    	public Elefant(){
    		super(4, 3000, 4);
    		lCount++;
    		elefantCount = lCount;
    	}
		public Elefant(double heigth, double weight, int legsCount) {
			super(heigth, weight, legsCount);
			lCount++;
			elefantCount = lCount;
		}

		public String Description() {
			return "I am the Elefant #"+elefantCount+": legs = " + getLegsCount() + 
					" height = " + getHeigth() +",weight="+getWeight()+";I have trunk";
		}   	
    }
    class Tiger extends Animals implements Feeding,Hunting,WhoAmI {
    	public static int lCount;
    	private int tigerCount = 0;
    	
       	public String eat(){
    		return "I eat meat only";
    	}
    	public String hunt() {
    		return "I can hunt";
    	}
		public Tiger(double heigth, double weight, int legsCount) {
			super(heigth, weight, legsCount);
			lCount++;
			tigerCount = lCount;
		}
   
		public String Description() {
			return "I am the Tiger #"+tigerCount+": legs = " + getLegsCount() + 
					" height = " + getHeigth()+",weight="+getWeight()
					+ "; " +hunt()+","+eat()+","+run();
		} 		
    }
    class Python extends Creatures implements Feeding,Hunting,WhoAmI {
    	public static int lCount;
    	private int PythonCount = 0; 
    	
       	public String eat(){
    		return "I swallow whole";
    	}
    	public String hunt() {
    		return "I can hunt";
    	}
		public Python(double heigth, double weight) { 
			super(heigth, weight, 0);
			lCount++;
			PythonCount = lCount;
		}
   
		public String Description() {
			return "I am the Python #"+PythonCount+": no legs " + " height = " + getHeigth()
					+ "; " +hunt()+","+eat()+"; cannot run, crawl";
		} 		
    	
    }
    class Duck extends Birds implements Feeding,Hunting,Flying, WhoAmI {
    	public static int lCount;
    	private int DuckCount = 0;
    	
       	public String eat(){
    		return "I eat duckweed";
    	}
    	public String hunt() {
    		return "I can hunt small fish";
    	}

		public String fly() {
			return "I can fly";
		}    	
		public Duck(double heigth, double weight, int legsCount) { 
			super(heigth, weight, legsCount);
			lCount++;
			DuckCount = lCount;
		}    	
		public String Description() {
			return "I am the Duck #"+DuckCount+": legs = " +getLegsCount()+ " height = " + getHeigth()
					+ "; " +hunt()+","+eat()+","+fly()+"; "+ layEggs();
		}     	
    }
    class Penguine extends Birds implements Feeding,Hunting, WhoAmI {
    	public static int lCount;
    	private int PenguineCount = 0;
    	
       	public String eat(){
    		return "I don't eat duckweed";
    	}
    	public String hunt() {
    		return "I can hunt sea fish";
    	}
   	
		public Penguine(double heigth, double weight, int legsCount) { 
			super(heigth, weight, legsCount);
			lCount++;
			PenguineCount = lCount;
		}    	
		public String Description() {
			return "I am the Penguine #"+PenguineCount+": legs = " +getLegsCount()+ " height = " + getHeigth()
					+ "; " +hunt()+","+eat()+"; "+ layEggs();
		}     	
    } 
    
public class Zoo {

	public static void main(String[] args){
		WhoAmI[] zoo1 = new WhoAmI[10];	
		
		for(int i=0;i<zoo1.length;i++){
			zoo1[i] = getZooHabitant(randInt(1,5)) ;
		}
		for(int i=0;i<zoo1.length;i++){
		System.out.println(zoo1[i].Description());
		}

	}
	
	static WhoAmI getZooHabitant(int c){
		//System.out.println(c);
		switch(c){
		case 1: return new Elefant( 3+Math.random()*3, 2000*(randInt(1,3)) , 4);
		case 2: return new Tiger(1,700*(randInt(1,3)),4);
		case 3: return new Python(7*Math.random()*3,300+Math.random()*100);
		case 4: return new Duck(1,6*Math.random(),2);
		case 5: return new Penguine(1.5,6*Math.random(),2);
		}
		return null;
	}
    static int randInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}	
}
