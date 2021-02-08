package model;


import java.util.Collection;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

/**
 * @author francoise.perrin
 * 
 * Cete classe fabrique et stocke toutes les PieceModel du Model dans une collection 
 * elle est donc responsable de rechercher et mettre � jour les PieceModel (leur position)
 * En r�alit�, elle d�l�gue � une fabrique le soin de fabriquer les bonnes PieceModel 
 * avec les bonnes coordonn�es
 * 
 * En revanche, elle n'est pas responsable des algorithme m�tiers li�s au d�placement des pi�ces
 * (responsabilit� de la classe Model)
 */
public class ModelImplementor {

	// la collection de pi�ces en jeu - m�lange noires et blanches
	private Collection<PieceModel> pieces ;	

	public ModelImplementor() {
		super();

		pieces = ModelFactory.createPieceModelCollection();
	}

	public PieceSquareColor getPieceColor(Coord coord) {
		PieceModel piece = null;
		PieceSquareColor color= null;
		
		if(findPiece(coord)!=null) {
			piece = this.findPiece(coord);
			color = piece.getPieceColor();
		}
		
		return color;
	}

	public boolean isPiecehere(Coord coord) {
		PieceModel piece = null;
		boolean isPiecehere = false;
		
		if(findPiece(coord)!=null) {
			piece = this.findPiece(coord);
			isPiecehere = piece.hasThisCoord(coord);
		}
		
		return isPiecehere;
	}

	public boolean isMovePieceOk(Coord initCoord, Coord targetCoord, boolean isPieceToTake) {
		PieceModel piece = null;
		boolean isMovePieceOk = false;
		
		if(findPiece(initCoord)!=null) {
			piece = this.findPiece(initCoord);
			isMovePieceOk = piece.isMoveOk(targetCoord, isPieceToTake);
		}
		
		return isMovePieceOk;
	}


	public boolean movePiece(Coord initCoord, Coord targetCoord) {
		PieceModel piece = findPiece(initCoord);
		boolean isMovePieceDone = false;
		
		if(piece !=null) {
			piece.move(targetCoord);
			isMovePieceDone = true;
		}
		
		return isMovePieceDone;
	}

	public void removePiece(Coord pieceToTakeCoord) {

		// TODO Atelier 2
		
	}

	
	public List<Coord> getCoordsOnItinerary(Coord initCoord, Coord targetCoord) {
		List<Coord> coordsOnItinerary = null;
		
		// TODO Atelier 2
		
		return coordsOnItinerary;
	}

	
	/**
	 * @param coord
	 * @return la pi�ce qui se trouve aux coordonn�es indiqu�es
	 */
	 private PieceModel findPiece(Coord coord) {		
		 
		PieceModel findPiece = null;
		
		for (PieceModel piece : pieces) {
			if(piece.hasThisCoord(coord)) {
				findPiece=piece;
				break;
			}
		}
			
		return findPiece;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * La m�thode toStrong() retourne une repr�sentation 
	 * de la liste de pi�ces sous forme d'un tableau 2D
	 * 
	 */
	public String toString() {


		String st = "";
		String[][] damier = new String[ModelConfig.LENGTH][ModelConfig.LENGTH];

		// cr�ation d'un tableau 2D avec les noms des pi�ces � partir de la liste de pi�ces
		for(PieceModel piece : this.pieces) {

			PieceSquareColor color = piece.getPieceColor();
			String stColor = (PieceSquareColor.WHITE.equals(color) ? "--B--" : "--N--" );

			int col = piece.getColonne() -'a';
			int lig = piece.getLigne() -1;
			damier[lig][col ] = stColor ;
		}

		// Affichage du tableau formatt�
		st = "     a      b      c      d      e      f      g      h      i      j\n";
		for ( int lig = 9; lig >=0 ; lig--) {
			st += (lig+1) + "  ";
			for ( int col = 0; col <= 9; col++) {					 
				String stColor = damier[lig][col];				
				if (stColor != null) {						
					st += stColor + "  ";	
				} 
				else {
					st += "-----  ";
				}
			}
			st +="\n";
		}
		
		return "\nDamier du model \n" + st;	
	}

}
