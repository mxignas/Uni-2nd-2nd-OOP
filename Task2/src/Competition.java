/*
class competition composes all the other classes via objects

float cal() - calculates the score
void add() - saves the data to class structure
void get() - to get the saved data from structure

Add() function saves the data in respective classes via class objects
and in Get() function only object values of datatypes are passed, so only
Member names, Difficulty rating, Description of routine/event, Score and Start time
objects are passed as an argument and their values have been changed as objects are passed
as references. Only Competitor Name, Number & Gender are the only variables that aren't
passed as an argument in Get() function as they cannot be referenced without wrapping them
in an object. So these 3 variables are accessed via Competition class object.
 */

public class Competition {

    competitor comp = new competitor();
    committeeMember[] cmem = new committeeMember[2];
    routine[] rt = new routine[10];
    event[] eve = new event[10];
    attempt[] at = new attempt[10];
    int mem_len, len;

    float cal(int pos, float diffRating) {
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        return diffRating * arr[pos - 1];
    }

    void add(String name, int unum, String[] comMember, int[] diffRating, String[] des, int[] pos, char gender) {
        comp.name = name;
        comp.number = unum;
        comp.gender = gender;
        len = diffRating.length;
        mem_len = comMember.length;

        for (int i = 0; i < comMember.length; i++) {
            cmem[i] = new committeeMember();
            cmem[i].name = comMember[i];
        }
        
        for (int j = 0; j < diffRating.length; j++) {
            rt[j] = new routine();
            eve[j] = new event();
            at[j] = new attempt();
            rt[j].difficultyRating = diffRating[j];
            at[j].score = cal(pos[j], diffRating[j]);
            eve[j].description = des[j].toUpperCase();
            switch (des[j].toUpperCase()) {
                case "FLOOR EXERCISE":
                    eve[j].startTime = 9;
                    break;
                case "POMMEL HORSE":
                    eve[j].startTime = 10;
                    break;
                case "STILL RINGS":
                    eve[j].startTime = 11;
                    break;
                case "VAULT":
                    eve[j].startTime = 12;
                    break;
                case "PARALLEL BARS":
                    eve[j].startTime = 13;
                    break;
                case "HIGH BAR":
                    eve[j].startTime = 14;
                    break;
                case "UNEVEN BARS":
                    eve[j].startTime = 15;
                    break;
                case "BALANCE BEAM":
                    eve[j].startTime = 16;
                    break;
            }
        }
    }

    String compName;
    int compNumber;
    char gen;

    void get(String[] cmemb, int[] dr, String[] d, float[] s, float[] sti) {
        compName = comp.name;
        compNumber = comp.number;
        gen = comp.gender;
        for (int i = 0; i < len; i++) {
            dr[i] = rt[i].difficultyRating;
            d[i] = eve[i].description;
            s[i] = at[i].score;
            sti[i] = eve[i].startTime;
        }
        for (int j = 0; j < mem_len; j++) {
            cmemb[j] = cmem[j].name;
        }
    }
}
