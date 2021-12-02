using System;
namespace Project_1 {
    class MainClass {
        public static void Main (string[] args) {
			string hello = "oi, mundo";
            Console.WriteLine (hello);
            short curto = 30000;
            int counter = 0;
            while(++counter < 5000){
				Console.WriteLine(++curto);
			}
            Console.ReadKey ();
        }
    }
}
