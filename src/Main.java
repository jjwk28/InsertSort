import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("10개의 숫자를 입력하시오 > ");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] a = new int[10];
		
		for(int i = 0; i < 10; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println();
		
		NLinkedList<Integer> list = new NLinkedList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i, a[i]);
		}
		
		for(int i = 1; i < 10; i++) {
			int idx = i;
			while(idx != 0) {
				if(list.get(idx) < list.get(idx-1)) {
					int tmp = list.remove(idx);
					list.add(idx-1, tmp);
					idx--;
				}
				else {
					break;
				}
			}
			sb.append(i + "단계 > ");
			for(int j = 0; j < list.size(); j++) {
				sb.append(list.get(j) + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
		System.out.print("삽입정렬 결과 >> ");
		show(list);
	}
	static void show(NLinkedList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
