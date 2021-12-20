package ru.geekbrains.lesson1;

public class Test {

    public static void main(String[] args) {

        Participants[] participants = new Participants[3];
        Challenge[] challenges = new Challenge[2];

        participants[0] = new Human(343.0, 2.12);
        participants[1] = new Cat(198.1, 3.312);
        participants[2] = new Robot(1000, 1.30);

        challenges[0] = new Treadmill(200);
        challenges[1] = new Wall(2.00);

        competitions(participants, challenges);

    }

    public static void competitions(Participants[] participants, Challenge[] challenges) {
        boolean[] outsider = new boolean[participants.length];

        System.out.println("Начало испытаний.");

        distanceRunningTest(participants, challenges, outsider);
        highJumpTest(participants, challenges, outsider);
        chekWinner(participants, outsider);
    }

    public static void distanceRunningTest(Participants[] participants, Challenge[] challenges, boolean[] outsider) {
        for (int participantNumber = 0; participantNumber < participants.length; participantNumber++) {
            if (outsider[participantNumber]) {
            } else if (challenges[0].meters() < participants[participantNumber].runDistance()) {
                System.out.println(participants[participantNumber].name() + " пробежал " + challenges[0].meters() + " метров");
            } else {
                System.out.println(participants[participantNumber].name() + " не пробежал " + challenges[0].meters() + " метров и выбывает из сорвенований ");
                outsider[participantNumber] = true;
            }
        }
    }

    public static void highJumpTest(Participants[] participants, Challenge[] challenges, boolean[] outsider) {
        for (int participantNumber = 0; participantNumber < participants.length; participantNumber++) {
            if (outsider[participantNumber]) {
            } else if (challenges[1].meters() < participants[participantNumber].jumpHeight()) {
                System.out.println(participants[participantNumber].name() + " перепрыгнул стену высотой " + challenges[1].meters() + " метра");
            } else {
                System.out.println(participants[participantNumber].name() + " не перепрыгнул стену высотой " + challenges[1].meters() + " метра и выбывает из соревнований");
                outsider[participantNumber] = true;
            }
        }
    }

    public static void chekWinner(Participants[] participants, boolean[] outsider) {
        for (int participantNumber = 0; participantNumber < participants.length; participantNumber++) {
            if (outsider[participantNumber]) {
            } else {
                System.out.println(participants[participantNumber].name() + " прошел все испытания.");
            }
        }
    }
}
