package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import nutsAndBolts.PieceSquareColor;

public class ModelFactory {

	public static Collection<PieceModel> createPieceModelCollection() {
		
		Collection<PieceModel> pieces = new LinkedList<PieceModel>();

		// Cr�ation des pion blancs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.WHITE_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.WHITE));
		}

		// Cr�ation des pions noirs et ajout dans la collection de pi�ces
		for ( Coord coord : ModelConfig.BLACK_PIECE_COORDS){
			pieces.add(new PawnModel(coord, PieceSquareColor.BLACK));
			}
		return pieces;
	}
}
