package el;
import java.util.*;

public class OurEaxPlayer extends Player{
	
	public final int[] cost={0, 4, 4, 4, 4, 2, 2, 2, 2, 1, 1};
	public final int maxPower = 7;

	@Override
	public void play(GameInfo info) {

		if(info.samuraiInfo[info.weapon].hidden==1){
				info.doAction(10);
		}
		
		//杀人去喽
		if(((info.samuraiInfo[info.weapon+1].curX!=info.samuraiInfo[info.weapon+1].homeX)
				&&(info.samuraiInfo[info.weapon+1].curY!=info.samuraiInfo[info.weapon+1].homeY))) {
			int[] a  = tryToKillEnemy(info,info.weapon+1);
			if (a!=null) {
				info.doAction(a[0]);
				info.doAction(a[1]);
			}
		}
		if(((info.samuraiInfo[info.weapon+2].curX!=info.samuraiInfo[info.weapon+2].homeX)
			&&(info.samuraiInfo[info.weapon+2].curY!=info.samuraiInfo[info.weapon+2].homeY))) {
			int[] b  = tryToKillEnemy(info,info.weapon+2);
			if (b!=null) {
				info.doAction(b[0]);
				info.doAction(b[1]);
			}
		}

		if(((info.samuraiInfo[info.weapon+3].curX!=info.samuraiInfo[info.weapon+3].homeX)
			&&(info.samuraiInfo[info.weapon+3].curY!=info.samuraiInfo[info.weapon+3].homeY))) {
			int[] c  = tryToKillEnemy(info,info.weapon+3);
			if (c!=null) {
				info.doAction(c[0]);
				info.doAction(c[1]);
			}
		}
	//偷袭算法





	//占地算法
	int choose = 0;
	choose=analyzeOccupyArea(info);
	info.doAction(choose);
	info.doAction(choose+4);

	if (info.samuraiInfo[info.weapon].hidden!=1){
		info.doAction(9);
	}
	}

	public int analyzeOccupyArea(GameInfo info){
		int[][] field = info.field;
		ArrayList<Integer> pActions = new ArrayList<Integer>();
		Random random = new Random();
		int range1=0;
		if(info.samuraiInfo[info.weapon].curY+1<info.height
				&&info.samuraiInfo[info.weapon].curY-1>=0
				&&info.samuraiInfo[info.weapon].curX+1<info.width
				&&info.samuraiInfo[info.weapon].curX-1>=0){
			range1=7;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==0){
			range1=3;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==0){
			range1=3;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range1=2;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range1=2;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==0){
			range1=5;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==info.height-1){
			range1=4;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0){
			range1=4;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range1--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1){
			range1=4;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range1--;
			}
		}
		int range2=0;
		if(info.samuraiInfo[info.weapon].curY+1<info.height
				&&info.samuraiInfo[info.weapon].curY-1>=0
				&&info.samuraiInfo[info.weapon].curX+1<info.width
				&&info.samuraiInfo[info.weapon].curX-1>=0){
			range2=7;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
	}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==0){
			range2=2;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
			
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==0){
			range2=3;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range2=3;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range2=2;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==0){
			range2=4;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==info.height-1){
			range2=4;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0){
			range2=5;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1){
			range2=4;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
		}
		int range3=0;
		if(info.samuraiInfo[info.weapon].curY+1<info.height
				&&info.samuraiInfo[info.weapon].curY-1>=0
				&&info.samuraiInfo[info.weapon].curX+1<info.width
				&&info.samuraiInfo[info.weapon].curX-1>=0){
			range3=7;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
	}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==0){
			range3=2;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==0){
			range3=2;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range3=3;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range3--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range3=3;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range3--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==0){
			range3=4;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==info.height-1){
			range3=5;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range3--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0){
			range3=4;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range3--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1){
			range3=4;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range3--;
			}
		}
		int range4=0;
		if(info.samuraiInfo[info.weapon].curY+1<info.height
				&&info.samuraiInfo[info.weapon].curY-1>=0
				&&info.samuraiInfo[info.weapon].curX+1<info.width
				&&info.samuraiInfo[info.weapon].curX-1>=0){
			range4=7;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
	}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==0){
			range4=3;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==0){
			range4=2;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range4=2;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1&&info.samuraiInfo[info.weapon].curY==info.height-1){
			range4=3;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range2--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range2--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==0){
			range4=4;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curY==info.height-1){
			range4=4;
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==0){
			range4=4;
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
		}
		else if(info.samuraiInfo[info.weapon].curX==info.width-1){
			range4=5;
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX-1]==info.weapon-2){
				range4--;
			}
			if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-1
					||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon-2){
				range4--;
			}
		}
		int[] range = {range1,range2,range3,range4};
		int maxRange=0;
		for(int i=0;i<range.length;i++){
			if(range[i]>maxRange){
				maxRange=range[i];
			}
		}
		for(int i=0;i<range.length;i++){
			if(range[i]==maxRange)
				pActions.add(i+1);
		}
		
		if(pActions.size()==1){
			return pActions.get(0);
		}
		else 
			return pActions.get(random.nextInt(pActions.size()));

	}
	public int[] tryToKillEnemy(GameInfo info,int weapon){
		int []action=new int[2];
		int myX = info.samuraiInfo[info.weapon].curX;
		int myY = info.samuraiInfo[info.weapon].curY;
		int enemyX = info.samuraiInfo[weapon].curX;
		int enemyY = info.samuraiInfo[weapon].curY;
		if((enemyX==myX+1&&(enemyY==myY+1||enemyY==myY||enemyY==myY-1))
				||(enemyX==myX&&enemyY==myY-1)
				||(enemyX==myX-1&&(enemyY==myY+1||enemyY==myY||enemyY==myY-1))){
			action[0]=3;
			action[1]=7;
			return action;
		}
		else if(enemyX==myX&&enemyY==myY+1){
			action[0]=1;
			action[1]=5;
			return action;
		}
		else if(enemyY==myY-2&&(enemyX==myX||enemyX==myX+1||enemyX==myX-1)){
			action[0]=7;
			action[1]=3;
			return action;
		}
		else if(enemyY==myY+2&&(enemyX==myX||enemyX==myX+1||enemyX==myX-1)){
			action[0]=5;
			action[1]=1;
			return action;
		}
		else if(enemyX==myX-2&&(enemyY==myY+1||enemyY==myY||enemyY==myY-1)){
			action[0]=4;
			action[1]=8;
			return action;
		}
		else if(enemyX==myX+22&&(enemyY==myY+1||enemyY==myY||enemyY==myY-1)){
			action[0]=2;
			action[1]=6;
			return action;
		}
		else{
			return null;
		}
	}

}
