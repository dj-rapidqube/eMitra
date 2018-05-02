package model;

import org.springframework.stereotype.Component;

@Component
public class NoteType {
	public static int total10Note;
	public static int total20Note;
	public static int total50Note;
	public static int total100Note;
	public static int total200Note;
	public static int total500Note;
	public static int total2000Note;
	public static int cashTimer;
	public static int depositAmount;
	
	public void setTotal10Note(int total10Note) {
		NoteType.total10Note = total10Note;
	}
	
	public void setTotal20Note(int total20Note) {
		NoteType.total20Note = total20Note;
	}
	
	public void setTotal50Note(int total50Note) {
		NoteType.total50Note = total50Note;
	}
	
	public void setTotal100Note(int total100Note) {
		NoteType.total100Note = total100Note;
	}
	
	public void setTotal200Note(int total200Note) {
		NoteType.total200Note = total200Note;
	}
	
	public void setTotal500Note(int total500Note) {
		NoteType.total500Note = total500Note;
	}
	
	public void setTotal2000Note(int total2000Note) {
		NoteType.total2000Note = total2000Note;
	}

	public void setCashTimer(int cashTimer) {
		NoteType.cashTimer = cashTimer;
	}

	public void setDepositAmount(int depositAmount) {
		NoteType.depositAmount = depositAmount;
	}
	
}
