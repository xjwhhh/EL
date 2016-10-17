package el;

public class Main {
	 public static void main(String[] argv){
	    	GameInfo info = new GameInfo();
	    	Player p = new RandomPlayer();//随机玩家

	    	while (true){
	    	    info.readTurnInfo();//读取回合信息？
	    	    System.out.println("# Turn "+info.turn);
	    	    if (info.curePeriod != 0){
	    		    System.out.println("0");//恢复周期不为0，恢复
	    	    }
	    	    else {
	    		    p.play(info);
	    		    System.out.println("0");//恢复周期为0，根据信息进行行动
	    	    }
	    	}
	    }
}
