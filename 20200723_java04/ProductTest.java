
public class ProductTest {

	public static void main(String[] args) {

		TV tv1 = new TV("KU75UT8070F", "삼성전자 시리즈8", 1871490, 45, 75, "led");
		TV tv2 = new TV("OLED55C9FNA", "LG전자 OLED55", 1563850, 30, 50, "oled");
		TV tv3 = new TV("42LK550", "LG전자 인피니아", 949990, 5, 42, "lcd");
		TV tv4 = new TV("KQ85QT67AF", "삼성전자 시리즈Q", 3516230, 10, 85, "led");

		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());
		System.out.println(tv4.toString());

		Refrigerator refrigerator1 = new Refrigerator("F871S11E", "LG전자 디오스", 1775740, 6, 870);
		Refrigerator refrigerator2 = new Refrigerator("RF85T9111T2", "삼성전자 비스포크", 1660290, 4, 871);
		Refrigerator refrigerator3 = new Refrigerator("R90M1-G", "대우 루컴즈", 193020, 3, 65);

		System.out.println(refrigerator1.toString());
		System.out.println(refrigerator2.toString());
		System.out.println(refrigerator3.toString());
	}

}
