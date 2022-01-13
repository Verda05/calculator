public class Num {

        int num1;
        int num2;
        int result;

        public Num(int num1,int num2) {
                this.num1 = num1;
                this.num2 = num2;
        }

        public void plus() {
                result = num1 + num2;
        }

        public void minus() {
                result = num1 - num2;
        }

        public void times() {
                result = num1*num2;
        }

        public void div() {
                result = num1/num2;
        }

        public int getResult() {
                return result;
        }
}