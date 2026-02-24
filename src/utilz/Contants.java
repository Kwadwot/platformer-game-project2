package utilz;

public class Contants {

    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int LANDING = 4;
        public static final int HURT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;

        public static int getSpriteAmount(int playerAction){
            return switch (playerAction) {
                case RUNNING -> 6;
                case IDLE -> 5;
                case HURT -> 4;
                case JUMP, ATTACK_1, ATTACK_JUMP_1, ATTACK_JUMP_2 -> 3;
                case LANDING -> 2;
                default -> 1;
            };
        }
    }
}
