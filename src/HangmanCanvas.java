/*
 * File: HangmanCanvas.java
 * ------------------------
 * Name: Hongyou Lin
 * 
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

	/* Constants for the simple version of the picture (in pixels) */
		private static final int SCAFFOLD_HEIGHT = 360;
		private static final int BEAM_LENGTH = 144;
		private static final int ROPE_LENGTH = 18;
		private static final int HEAD_RADIUS = 36;
		private static final int BODY_LENGTH = 144;
		private static final int ARM_OFFSET_FROM_HEAD = 28;
		private static final int UPPER_ARM_LENGTH = 72;
		private static final int LOWER_ARM_LENGTH = 44;
		private static final int HIP_WIDTH = 36;
		private static final int LEG_LENGTH = 108;
		private static final int FOOT_LENGTH = 28;
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		Scaffold();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		int x = getWidth()/4;
		int y = getHeight() - HEAD_RADIUS*2;
		if (getElementAt(x,y) != null) {
			remove(getElementAt(x,y));
		}
		GLabel answer = new GLabel(word,x, y);
		answer.setFont("Helvetica-24");
		add (answer);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String IncorrectLetter) {
        int x = getWidth()/4;
        int y = getHeight() - HEAD_RADIUS;
        if (getElementAt(x,y) != null) {  // prevent letters overlaps with each other;
        	remove(getElementAt(x,y));
        }
		GLabel wrongGuess = new GLabel(IncorrectLetter, x, y);
        add(wrongGuess);
        // allow the graphics to keep updated with the reduce in chances for the player;
        if(IncorrectLetter.length() == 1) {
            Head();
        }
        else if(IncorrectLetter.length() == 2) {
            Body();
        }
        else if(IncorrectLetter.length() == 3) {
            LeftArm();
        }
        else if(IncorrectLetter.length() == 4) {
            RightArm();
        }
        else if(IncorrectLetter.length() == 5) {
            LeftLeg();
        }
        else if(IncorrectLetter.length() == 6) {
            RightLeg();
        }
        else if(IncorrectLetter.length() == 7) {
            LeftFoot();
        }
        else if(IncorrectLetter.length() == 8) {
            RightFoot();
        }
    }
	
	 private void Scaffold() {
	        int X = getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD;
	        int Y = getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4;
	        GLine scaffold= new GLine (X, Y, X, Y + SCAFFOLD_HEIGHT);
	        add(scaffold);
	        GLine beam = new GLine(X, Y, X + BEAM_LENGTH, Y);
	        add(beam);
	        GLine rope = new GLine (X + BEAM_LENGTH, Y, X + BEAM_LENGTH, Y + ROPE_LENGTH);
	        add(rope);
	 }
	 
	 private void Head() {
		 GOval head = new GOval (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - 2*HEAD_RADIUS/2, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + ROPE_LENGTH, 2*HEAD_RADIUS, 2*HEAD_RADIUS);
		 add(head);
	 }
 
	 private void Body() {
		 GLine body = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH);
		 add(body);
		 GLine hip = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH);
		 add(hip);
	 }
	 
	 private void RightArm() {
		 GLine rightArm = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		 add (rightArm);
		 GLine rightHand = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		 add (rightHand);
	 }
	 
	 private void LeftArm() {
		 GLine leftArm = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		 add(leftArm);
		 GLine leftHand = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + UPPER_ARM_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2.5*HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		 add(leftHand);
	 }
	 
	 private void LeftLeg() {
		 GLine leftLeg = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		 add (leftLeg);
	 }
	
	 private void LeftFoot () {
		 GLine leftFoot = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH - HIP_WIDTH - FOOT_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH); 
		 add (leftFoot);
	 }
	 
	 private void RightLeg() {
		 GLine rightLeg = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		 add(rightLeg);
	 }
		 
	 private void RightFoot() {
		 GLine rightFoot = new GLine (getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + HIP_WIDTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, getWidth()/2 - UPPER_ARM_LENGTH - ARM_OFFSET_FROM_HEAD + BEAM_LENGTH + HIP_WIDTH + FOOT_LENGTH, getHeight()/2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH*4 + 2*HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		 add(rightFoot);
	 }
}
