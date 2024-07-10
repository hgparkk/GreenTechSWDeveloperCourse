package myProject;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MineGame {
	private LocalTime start;
	private LocalTime end;
	private String[][] field;
	private int[][] showField;

	private MineGame() {
		start = LocalTime.now();
		field = initialField();
		showField = new int[10][10];
	};

	private static MineGame instance = new MineGame();

	public static MineGame getInstance() {
		return instance;
	}
	
	public LocalTime getStart() {
		return start;
	}
	
	public LocalTime getEnd() {
		return end;
	}
	
	public String[][] getField() {
		return field;
	}
	
	public int[][] getShowField(){
		return showField;
	}
	
	public void setEnd(LocalTime end) {
		this.end = end;
	}

	//지뢰 주변 칸에 주변 지뢰수를 증가하시키는 함수
	private void incMineAround(String[][] field, int y, int x) {
		if(field[y][x] != "Mine") {
			field[y][x] = (Integer.parseInt(field[y][x]) + 1) + "";
		}
	}

	// 지뢰 위치 설정
	private String[][] initialField() {

		// 지뢰 갯수
		final int mineCount = 10;
		final int rows = 10;
		final int cols = 10;

		// 지뢰필드 정보가 들어갈 배열
		String[][] field = new String[rows][cols];

		// 지뢰필드 0으로 초기화
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = "0";
			}
		}

		// 지뢰 위치 임시 저장
		Set<Integer> mineLocations = new HashSet<>();
        while (mineLocations.size() < mineCount) {
            mineLocations.add((int) (Math.random() * rows * cols));
        }

		// 지뢰 깔기
        for (int loc : mineLocations) {
            int i = loc / cols;
            int j = loc % cols;
            field[i][j] = "Mine";

            // 지뢰 주변의 칸 업데이트
            for (int dy = -1; dy <= 1; dy++) {
                for (int dx = -1; dx <= 1; dx++) {
                    int newY = i + dy;
                    int newX = j + dx;
                    if (newY >= 0 && newY < rows && newX >= 0 && newX < cols) {
                        incMineAround(field, newY, newX);
                    }
                }
            }
        }

        return field;
    }
	
	//해당 좌표의 결과 반환
	public int checkMine(int y, int x) {
		//이미 결과를 아는 좌표 입력
		if(showField[y][x] == 1) {
			System.out.println("잘못된 입력입니다.");
			return 0;
		}else {
			//지뢰 밟음
			if(field[y][x].equals("Mine")) {
				return 2;
			//주변에 지뢰가 있는 칸을 확인할 때
			}else if(!field[y][x].equals("0")){
				showField[y][x] = 1;
			//주변에 지뢰가 없는 칸을 확인할 때
			}else {
				openAdjacentZeros(y,x);
			}
			return 1;
		}
	}
	
	//주변에 지뢰가 없는 칸을 열었을 때 주변에 지뢰가 없는 칸 연속적으로 열기
	private void openAdjacentZeros(int y, int x) {
	    // 스택을 사용하여 DFS를 구현
	    Stack<int[]> stack = new Stack<>();
	    stack.push(new int[]{y, x});

	    while (!stack.isEmpty()) {
	        int[] pos = stack.pop();
	        int curY = pos[0];
	        int curX = pos[1];

	        // 현재 위치가 이미 열렸다면 건너뜀
	        if (showField[curY][curX] == 1) continue;

	        // 현재 위치를 염
	        showField[curY][curX] = 1;

	        // 주변 8방향을 확인하여 0인 경우 스택에 추가
	        for (int dy = -1; dy <= 1; dy++) {
	            for (int dx = -1; dx <= 1; dx++) {
	                int newY = curY + dy;
	                int newX = curX + dx;

	                if (newY >= 0 && newY < field.length && newX >= 0 && newX < field[0].length) {
	                    if (field[newY][newX].equals("0") && showField[newY][newX] == 0) {
	                        stack.push(new int[]{newY, newX});
	                    } else if (!field[newY][newX].equals("Mine")) {
	                        showField[newY][newX] = 1;
	                    }
	                }
	            }
	        }
	    }
	}
	
	//성공 여부
	public boolean checkClear() {
		int count=0;
		for(int i=0;i<showField.length;i++) {
			for(int j=0;j<showField[i].length;j++) {
				if(showField[i][j] == 0) {
					count++;
				}
			}
		}
		if(count==10) {
			end = LocalTime.now();
			return true;
		}else {
			return false;
		}
	}
}