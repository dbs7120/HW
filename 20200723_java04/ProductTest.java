
public class ProductTest {

	public static void main(String[] args) {

		TV tv1 = new TV("KU75UT8070F", "�Ｚ���� �ø���8", 1871490, 45, 75, "led");
		TV tv2 = new TV("OLED55C9FNA", "LG���� OLED55", 1563850, 30, 50, "oled");
		TV tv3 = new TV("42LK550", "LG���� ���ǴϾ�", 949990, 5, 42, "lcd");
		TV tv4 = new TV("KQ85QT67AF", "�Ｚ���� �ø���Q", 3516230, 10, 85, "led");

		System.out.println(tv1.toString());
		System.out.println(tv2.toString());
		System.out.println(tv3.toString());
		System.out.println(tv4.toString());

		Refrigerator refrigerator1 = new Refrigerator("F871S11E", "LG���� �����", 1775740, 6, 870);
		Refrigerator refrigerator2 = new Refrigerator("RF85T9111T2", "�Ｚ���� ����ũ", 1660290, 4, 871);
		Refrigerator refrigerator3 = new Refrigerator("R90M1-G", "��� ������", 193020, 3, 65);

		System.out.println(refrigerator1.toString());
		System.out.println(refrigerator2.toString());
		System.out.println(refrigerator3.toString());
	}

}
