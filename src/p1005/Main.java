package p1005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	// 건설시간, 건설총시간, 선행건물목록을 가진 빌딩 클래스
	static class Building {
		int buildTime;
		int totalBuildTime = -1;
		List<Building> preBuildingList;
		
		public Building(int buildTime) {
			this.buildTime = buildTime;
			preBuildingList = new ArrayList<>();
		}
	}
	
	// 선행건물들의 건설총시간 중 최댓값 구하는 메소드
	static int getPreBuildTime(Building building) {
		int max = 0;
		for (Building preBuilding : building.preBuildingList) {
			if (max < getTotalBuildTime(preBuilding))
				max = getTotalBuildTime(preBuilding);
		}
		return max;
	}
	
	// 건설총시간 구하는 메소드
	static int getTotalBuildTime(Building building) {
		if (building.totalBuildTime != -1)
			return building.totalBuildTime;
		building.totalBuildTime = getPreBuildTime(building) + building.buildTime;
		return building.totalBuildTime;
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		// 테스트 케이스의 수 만큼 반복
		for (int t = 0; t < T; t++) {
			int numberOfBuilding = scanner.nextInt();
			int numberOfOrder = scanner.nextInt();
			Building[] buildingList = new Building[numberOfBuilding];
			// 건물목록을 배열에 담기
			for (int i = 0; i < numberOfBuilding; i++) {
				int buildTime = scanner.nextInt();
				
				buildingList[i] = new Building(buildTime);
			}
			// 선행건물목록 ArrayList에 추가
			for (int i = 0; i < numberOfOrder; i++) {
				int preBuilding = scanner.nextInt() - 1;
				int targetBuilding = scanner.nextInt() - 1;
				
				buildingList[targetBuilding].preBuildingList.add(buildingList[preBuilding]);
			}
			int targetBuilding = scanner.nextInt() - 1;
			System.out.println(getTotalBuildTime(buildingList[targetBuilding]));
		}
	}

}
