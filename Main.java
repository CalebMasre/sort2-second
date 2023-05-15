
public class Main {

	public static void main(String[] args) {
		Quiz quiz1 = new Quiz("math", 1, 60, true);
		Quiz quiz2 = new Quiz("math", 2, 60, true);
		Quiz quiz3 = new Quiz("math", 3, 60, true);
		
		Quiz quiz4 = new Quiz("S.S", 1, 60, true);
		Quiz quiz5 = new Quiz("S.S", 2, 60, true);
		Quiz quiz6 = new Quiz("S.S", 3, 60, true);
		
		Quiz quiz7 = new Quiz("Science", 1, 60, true);
		Quiz quiz8 = new Quiz("science", 2, 60, true);
		Quiz quiz9 = new Quiz("science", 3, 60, true);
		
		Quiz quiz10 = new Quiz("english", 1, 60, true);
		Quiz quiz11 = new Quiz("english", 2, 60, true);
		Quiz quiz12 = new Quiz("english", 3, 60, true);
		
		MergeSort ms = new MergeSort<>();
		HeapSort hs = new HeapSort<>();
		QuickSort qs = new QuickSort<>();
		ShellSort ss = new ShellSort<>();
				
		Comparable[]quizzes = {(Comparable) quiz1, (Comparable) quiz3, (Comparable) quiz2};
		
		Comparable[]quizzes2 = {(Comparable) quiz4, (Comparable) quiz5, (Comparable) quiz6};
		Comparable[]quizzes3 = {(Comparable) quiz9, (Comparable) quiz8, (Comparable) quiz7};
		Comparable[]quizzes4 = {(Comparable) quiz12, (Comparable) quiz10, (Comparable) quiz11};
		
		
		
		//The quizzes were sorted by the number of questions that they have
		
		
		//heapsort
		System.out.println("HEAP SORT");
		System.out.println("quizzes before sorting");
		print(quizzes);
		hs.sort(quizzes);
		System.out.println("quizzes after sorting");
		print(quizzes);
		System.out.println();
		
		
		//mergesort
		System.out.println("MERGE SORT");
		System.out.println("quizzes before sorting");
		print(quizzes2);
		ms.mergeSort(quizzes2);
		System.out.println("quizzes after sorting");
		print(quizzes2);
		System.out.println();
		
		//quick sort
		System.out.println("QUICK SORT");
		System.out.println("quizzes before sorting");
		print(quizzes3);
		qs.quickSort(quizzes3);
		System.out.println("quizzes after sorting");
		print(quizzes3);
		System.out.println();
		
		//Shell sort
		System.out.println("SHELL SORT");
		System.out.println("quizzes before sorting");
		print(quizzes4);
		ss.sort(quizzes4);
		System.out.println("quizzes after sorting");
		print(quizzes4);
		System.out.println();
		
		
		
		
		
		

	}
	public static <T> void print(T arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i].toString() + " ");
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void verify(T arr[]) {

		int count = 0;
		while (count < arr.length - 1) {
			T obj = arr[count];
			if (((Comparable<T>) arr[count]).compareTo(arr[count + 1]) > 0) {
				System.out.println("NOT SORTED");
				return;
			}
			count++;
		}

		System.out.println("SORTED");

	}

}

class CourseItem implements Comparable{
    private String itemName;
    private int numQuestions;

    public CourseItem() {
        this.itemName = "Default";
        this.numQuestions = 0;
    }

    public CourseItem(String itemName, int numQuestions) {
        this.itemName = itemName;
        this.numQuestions = numQuestions;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public void print() {
        System.out.println("Course item: " + itemName);
        System.out.println("Number of questions: " + numQuestions);
    }

    /*
     * Using Number of questions on the Course items to compare Quizzes
     * to eachother. 
     * */
	@Override
	public int compareTo(Object o) {
		if(this.getNumQuestions() > ((CourseItem) o).getNumQuestions()) {
			return 1;
		} else if(this.getNumQuestions() < ((CourseItem) o).getNumQuestions()){
			return -1;
		} else {
			return 0;
		}
	}
}

class Quiz extends CourseItem {
    private int timeLimit;
    private boolean isGraded;

    private static int numQuizzes = 0;

    public Quiz() {
        super();
        this.timeLimit = 0;
        this.isGraded = true;
        numQuizzes++;
    }

    public Quiz(String itemName, int numQuestions, int timeLimit, boolean isGraded) {
        super(itemName, numQuestions);
        this.timeLimit = timeLimit;
        this.isGraded = isGraded;
        numQuizzes++;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean getIsGraded() {
        return isGraded;
    }

    public void setIsGraded(boolean isGraded) {
        this.isGraded = isGraded;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Time limit: " + timeLimit);
        System.out.println("Is graded: " + isGraded);
    }
    @Override public String toString() {
    	return this.getItemName() + " quiz with "  + this.getNumQuestions() + " question(s)";
    }

    public static int getNumQuizzes() {
        return numQuizzes;
    }
}

