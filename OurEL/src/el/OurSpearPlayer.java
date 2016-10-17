package el;

	import java.util.ArrayList;
	import java.util.Random;

	public class OurSpearPlayer extends Player {
		public void play(GameInfo info) {
			if(info.samuraiInfo[info.weapon].hidden==1){
				info.doAction(10);
			}
			
			
//			if(!isEnemySeen(info)){
//				choose=analyzeOccupyArea(info);
//				info.doAction(choose);
//				info.doAction(choose+4);
//			}
			//先执行尝试杀敌算法
			if(((info.samuraiInfo[info.weapon+3].curX!=info.samuraiInfo[info.weapon+3].homeX)
						&&(info.samuraiInfo[info.weapon+3].curY!=info.samuraiInfo[info.weapon+3].homeY))) {
				int[] a  = tryToKillEnemy(info,info.weapon+3);
				if (a!=null) {
					info.doAction(a[0]);
					info.doAction(a[1]);
				}
			}
			if(((info.samuraiInfo[info.weapon+4].curX!=info.samuraiInfo[info.weapon+4].homeX)
					&&(info.samuraiInfo[info.weapon+4].curY!=info.samuraiInfo[info.weapon+4].homeY))) {
				int[] b  = tryToKillEnemy(info,info.weapon+4);
				if (b!=null) {
					info.doAction(b[0]);
					info.doAction(b[1]);
				}
			}
			
			if(((info.samuraiInfo[info.weapon+5].curX!=info.samuraiInfo[info.weapon+5].homeX)
					&&(info.samuraiInfo[info.weapon+5].curY!=info.samuraiInfo[info.weapon+5].homeY))) {
				int[] c  = tryToKillEnemy(info,info.weapon+5);
				if (c!=null) {
					info.doAction(c[0]);
					info.doAction(c[1]);
				}
			}
			//这里添加贤惠写的偷袭算法
			
			
			
			//最后执行的普通占地算法
			int choose = 0;
			choose=analyzeOccupyArea(info);
			info.doAction(choose);
			info.doAction(choose+4);
			
			if (info.samuraiInfo[info.weapon].hidden!=1){
				info.doAction(9);
			}
		}
		
//		//判断敌军是否在我军的视野内。
//		public boolean isEnemySeen(GameInfo info){
//			boolean isSeen=true;
//			if(info.samuraiInfo[info.weapon+3].curX==-1&&info.samuraiInfo[info.weapon+3].curY==-1){
//				isSeen=false;
//			}
//			if(info.samuraiInfo[info.weapon+4].curX==-1&&info.samuraiInfo[info.weapon+4].curY==-1){
//				isSeen=false;
//			}
//			if(info.samuraiInfo[info.weapon+5].curX==-1&&info.samuraiInfo[info.weapon+5].curY==-1){
//				isSeen=false;
//			}
//			return isSeen;
//		}

		//根据四周的占地情况给出行动
		public int analyzeOccupyArea(GameInfo info){
			int[][] field = info.field;
			ArrayList<Integer> pActions = new ArrayList<Integer>();
			Random random = new Random();
			
			int range1=0;
			if(info.samuraiInfo[info.weapon].curY+4<info.width){
				range1=4;
				if(field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon+1
						||field[info.samuraiInfo[info.weapon].curY+1][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range1--;
				}
				if(field[info.samuraiInfo[info.weapon].curY+2][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY+2][info.samuraiInfo[info.weapon].curX]==info.weapon+1
						||field[info.samuraiInfo[info.weapon].curY+2][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range1--;
				}
				if(field[info.samuraiInfo[info.weapon].curY+3][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY+3][info.samuraiInfo[info.weapon].curX]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY+3][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range1--;
				}
				if(field[info.samuraiInfo[info.weapon].curY+4][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY+4][info.samuraiInfo[info.weapon].curX]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY+4][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range1--;
				}
				
			}
			
			int range2=0;
			if(info.samuraiInfo[info.weapon].curX+4<info.height){
				range2=4;
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+1]==info.weapon+2){
					range2--;
				}
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+2]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+2]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+2]==info.weapon+2){
					range2--;
				}
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+3]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+3]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+3]==info.weapon+2){
					range2--;
				}
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+4]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+4]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX+4]==info.weapon+2){
					range2--;
				}
				
			}
			
			int range3=0;
			if(info.samuraiInfo[info.weapon].curY-4>=0){
				range3=4;
				if(field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY-1][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range3--;
				}
				if(field[info.samuraiInfo[info.weapon].curY-2][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY-2][info.samuraiInfo[info.weapon].curX]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY-2][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range3--;
				}
				if(field[info.samuraiInfo[info.weapon].curY-3][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY-3][info.samuraiInfo[info.weapon].curX]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY-3][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range3--;
				}
				if(field[info.samuraiInfo[info.weapon].curY-4][info.samuraiInfo[info.weapon].curX]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY-4][info.samuraiInfo[info.weapon].curX]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY-4][info.samuraiInfo[info.weapon].curX]==info.weapon+2){
					range3--;
				}
				
			}
			
			int range4=0;
			if(info.samuraiInfo[info.weapon].curX-4>=0){
				range4=4;
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-1]==info.weapon+2){
					range4--;
				}
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-2]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-2]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-2]==info.weapon+2){
					range4--;
				}
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-3]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-3]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-3]==info.weapon+2){
					range4--;
				}
				if(field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-4]==info.weapon
						||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-4]==info.weapon+1
								||field[info.samuraiInfo[info.weapon].curY][info.samuraiInfo[info.weapon].curX-4]==info.weapon+2){
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
//		//锁定最近的敌人
//		public int nearestEnemy(GameInfo info){
//			int[] weapon  = {3,4,5};
//			int index=0;
//			int distance = 5;
//			
//			for(int i = 0;i<3;i++){
//				distance = Math.min(distance, Math.abs(info.samuraiInfo[info.weapon].curX+info.samuraiInfo[info.weapon].curY-info.samuraiInfo[info.weapon+weapon[i]].curX-info.samuraiInfo[info.weapon+weapon[i]].curY));
//			}
//			for(int i=0;i<3;i++){
//				if(distance==Math.abs(info.samuraiInfo[info.weapon].curX+info.samuraiInfo[info.weapon].curY-info.samuraiInfo[info.weapon+weapon[i]].curX-info.samuraiInfo[info.weapon+weapon[i]].curY)){
//					index=i;
//					break;
//				}
//			}
//			return weapon[index];
//			
//		}
		
		//尝试干掉敌人
		public int[] tryToKillEnemy(GameInfo info,int weapon){
//			int[][] field = info.field;
			int[] action = new int[2]; 
			int myX = info.samuraiInfo[info.weapon].curX;
			int myY = info.samuraiInfo[info.weapon].curY;
			int enemyX = info.samuraiInfo[weapon].curX;
			int enemyY = info.samuraiInfo[weapon].curY;
			
			if((enemyX==myX&&enemyY==myY+1)
					||(enemyX==myX&&enemyY==myY+2)
					||(enemyX==myX&&enemyY==myY+3)
					||(enemyX==myX&&enemyY==myY+4)){
				action[0] = 1;
				action[1] = 5;
				return action;
			}
			else if((enemyX==myX&&enemyY==myY+5)){
				action[0] = 5;
				action[1] = 1;
				return action;
			}
			else if((enemyX==myX+1&&enemyY==myY)
					||(enemyX==myX+2&&enemyY==myY)
					||(enemyX==myX+3&&enemyY==myY)
					||(enemyX==myX+4&&enemyY==myY)){
				action[0] = 2;
				action[1] = 6;
				return action;
			}
			else if(enemyX==myX+5&&enemyY==myY){
				action[0] = 6;
				action[1] = 2;
				return action;
			}
			else if((enemyX==myX&&enemyY==myY-1)
					||(enemyX==myX&&enemyY==myY-2)
					||(enemyX==myX&&enemyY==myY-3)
					||(enemyX==myX&&enemyY==myY-4)){
				action[0] = 3;
				action[1] = 7;
				return action;
			}
			else if((enemyX==myX&&enemyY==myY-5)){
				action[0] = 7;
				action[1] = 3;
				return action;
			}
			else if((enemyX==myX-1&&enemyY==myY)
					||(enemyX==myX-2&&enemyY==myY)
					||(enemyX==myX-3&&enemyY==myY)
					||(enemyX==myX-4&&enemyY==myY)){
				action[0] = 4;
				action[1] = 8;
				return action;
			}
			else if(enemyX==myX-5&&enemyY==myY){
				action[0] = 8;
				action[1] = 4;
				return action;
			}
			else if ((enemyX==myX+1&&enemyY==myY+1)
					||(enemyX==myX+2&&enemyY==myY+1)
					||(enemyX==myX+3&&enemyY==myY+1)
					||(enemyX==myX+4&&enemyY==myY+1)) {
				action[0] = 5;
				action[1] = 2;
				return action;
			}
			else if ((enemyX==myX+1&&enemyY==myY+1)
					||(enemyX==myX+1&&enemyY==myY+2)
					||(enemyX==myX+1&&enemyY==myY+3)
					||(enemyX==myX+1&&enemyY==myY+4)) {
				action[0] = 6;
				action[1] = 1;
				return action;
			}
			else if ((enemyX==myX-1&&enemyY==myY+1)
					||(enemyX==myX-1&&enemyY==myY+2)
					||(enemyX==myX-1&&enemyY==myY+3)
					||(enemyX==myX-1&&enemyY==myY+4)) {
				action[0] = 8;
				action[1] = 1;
				return action;
			}
			else if ((enemyX==myX-1&&enemyY==myY+1)
					||(enemyX==myX-2&&enemyY==myY+1)
					||(enemyX==myX-3&&enemyY==myY+1)
					||(enemyX==myX-4&&enemyY==myY+1)) {
				action[0] = 5;
				action[1] = 4;
				return action;
			}
			else if ((enemyX==myX+1&&enemyY==myY-1)
					||(enemyX==myX+2&&enemyY==myY-1)
					||(enemyX==myX+3&&enemyY==myY-1)
					||(enemyX==myX+4&&enemyY==myY-1)) {
				action[0] = 7;
				action[1] = 2;
				return action;
			}
			else if ((enemyX==myX+1&&enemyY==myY-1)
					||(enemyX==myX+1&&enemyY==myY-2)
					||(enemyX==myX+1&&enemyY==myY-3)
					||(enemyX==myX+1&&enemyY==myY-4)) {
				action[0] = 6;
				action[1] = 3;
				return action;
			}
			else if ((enemyX==myX-1&&enemyY==myY-1)
					||(enemyX==myX-1&&enemyY==myY-2)
					||(enemyX==myX-1&&enemyY==myY-3)
					||(enemyX==myX-1&&enemyY==myY-4)) {
				action[0] = 8;
				action[1] = 3;
				return action;
			}
			else if ((enemyX==myX-1&&enemyY==myY-1)
					||(enemyX==myX-2&&enemyY==myY-1)
					||(enemyX==myX-3&&enemyY==myY-1)
					||(enemyX==myX-4&&enemyY==myY-1)) {
				action[0] = 7;
				action[1] = 4;
				return action;
			}
			
			else {
				return null;
			}

			
		}
}
