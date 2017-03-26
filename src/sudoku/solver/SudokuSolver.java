
package sudoku.solver;
import java. lang.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;
import java.io.PrintStream;

public class SudokuSolver {
int ROW = 9;
int COL = 9;
static int clauses =0;
static String string1 = "";
public static void rule_1(){
	int i, j, k;
	for(i = 1; i < 10; i++){
		for(j = 1; j < 10; j++){
			for(k = 1; k < 10; k++){
                            string1 += i;
                            string1 += j;
                            string1 += k + " ";
				//System.out.printf("%d%d%d ",i,j,k);
			}
			string1+=("0\r\n");
			clauses++;
		}	}}
public static void rule_2(){
        int i, j, k, l;
        for(i = 1; i < 10; i++){
                for(j = 1; j < 10; j++){
                        for(k = 1; k < 10; k++){
				for(l = j + 1; l < 10; l++){
					string1 += "-"+i;
                                        string1 += j;
                                        string1 += k + " ";
                                        string1 += "-"+i;
                                        string1 += l;
                                        string1 += k + " 0\r\n";
					(clauses)++;
				} }  }    }}
public static void rule_3(){
        int i, j, k, l;
        for(i = 1; i < 10; i++){
                for(j = 1; j < 10; j++){
                        for(k = 1; k < 10; k++){
                                for(l = i + 1; l < 10; l++){
                                        string1 += "-"+i;
                                        string1 += j;
                                        string1 += k + " ";
                                        string1 += "-"+l;
                                        string1 += j;
                                        string1 += k + " 0\r\n";
                                        (clauses)++;
                               } }    }      }}
public static void rule_4(){
	int a, b, i, j, k, l, m;
	for(a = 0; a < 9; a+=3){
	for(b = 0; b < 9; b+=3){
	for(i = 1; i < 4; i++){
	for(j = 1; j < 4; j++){
	for(k = 1; k < 10; k++){
	for(l = j; l < 4; l++){
	for(m = i; m < 4; m++){
		if(m == i && l== j){
			continue;
		}		
                                        string1 += "-"+ (i + b);
                                        string1 += (j+a);
                                        string1 += k + " ";
                                        string1 += "-"+(m+b);
                                        string1 += (l+a);
                                        string1 += k + " 0\r\n";
		(clauses)++;	
	}	}} }}}}}
    public static void main(String[] args) {
        string1 += "c RULE 1 STARTS HERE\r\n";
        rule_1();
        string1 += "c RULE 2 STARTS HERE\r\n";
        rule_2();
        string1 += "c RULE 3 STARTS HERE\r\n";
        rule_3();
        string1 += "c RULE 4 STARTS HERE\r\n";
        rule_4();
        System.out.printf(string1);
        try{
        PrintStream out = new PrintStream("output.txt");
        out.print(string1);
        }
        catch(java.io.FileNotFoundException e){}
    }   }










/*
void print_grid(char array[ROW][COL]){
	int i, j;
	for(i = 0; i < ROW; i++){
		for(j = 0; j < COL; j++){
			printf("%c", array[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}
// add end comment here

int main(int argc, char* argv[]){
	FILE* fp;
	FILE* fp2;

	int variables, clauses;
	variables = ROW * COL * 9;
	clauses = 0;

	char buffer[100];
	char array[ROW][COL];

	fp = fopen(argv[1], "r");
	if(!fp){
		printf("Error trying to read input, now exiting.\n");
		return -1;
	}
	//check for error fp

	fgets(buffer, 60, fp);
	printf("%s", buffer);//print grid # line
	
	int i, j;
	for(i = 0; i < ROW; i++){
		for(j = 0; j <= COL; j++){//<= is necessary!
			char c = fgetc(fp);
			if(c == '\n'){
				continue;
			}else{
				array[i][j] = c;
			}
		}
	}

	//print_grid(array);


//rule_1(array, &clauses);
//rule_2(array, &clauses);
//rule_3(array, &clauses);
rule_4(array, &clauses);//not a pointer for clauses, change!


//WRITE TO FILE 
	fp2 = fopen("output.txt", "w+");
	char firstLine[10];
	sprintf(firstLine, "p cnf %d %d\n", variables, clauses);
	fwrite(firstLine, 1, sizeof(firstLine), fp2);

	fclose(fp);
	fclose(fp2);



	exit(0);
}


*/