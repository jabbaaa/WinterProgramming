import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.music.tools.*;

public class SoundtrackWorking{
  
  double a2 = JMC.A2;   double b2 = JMC.B2;   double c3 = JMC.C3;    double d3 = JMC.D3;
  double e3 = JMC.E3;   double fs3 = JMC.FS3; double g3 = JMC.G3;    double a3 = JMC.A3;
  double b3 = JMC.B3;   double c4 = JMC.C4;   double d4 = JMC.D4;    double e4 = JMC.E4;
  double fs4 = JMC.FS4; double g4 = JMC.G4;   double a4 = JMC.A4;    double b4 = JMC.B4;
  double c5 = JMC.C5;   double d5 = JMC.D5;   double e5 = JMC.E5;    double fs5 = JMC.FS5;
  double qn = JMC.QN;   double hn = JMC.HN;   double dhn = JMC.DHN;  double wn = JMC.WN;
  double sn = JMC.SN;   double en = JMC.EN;   double dqn = JMC.DQN;  double rest = JMC.REST;
  double den = JMC.DEN; double g2 = JMC.G2;   double fs2 = JMC.FS2;  double e2 = JMC.E2;
  double a1 = JMC.A1;   double b5 = JMC.B5;   double as4 = JMC.AS4;  double fs6 = JMC.FS6;
  double e6 = JMC.E6;   double g6 = JMC.G6;   double c6 = JMC.C6;    double g5 = JMC.G5;
  double a5 = JMC.A5;   double a6 = JMC.A6;   double b6 = JMC.B6;    double d6 = JMC.D6;

  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  double[] treble1_5 = {c4, wn, /**/ rest, hn, d5, qn, c5, qn, /**/ a4, wn, /**/ 
    rest, dqn, d4, en, e4, qn, g4, qn, /**/ g4, (sn / 2), a4, (dhn + (3.5 * sn)) /**/};
  
  double[] trebleharm1_5 = {c5, dqn, a4, en, e4, en, c4, en, e4, qn, /**/ rest, hn, b5, qn, e5, qn, /**/ 
    g4, hn, a4, hn, /**/ g4, en, rest, qn, d4, en, e4, qn, d4, qn, /**/ g4, (sn / 2), c5, (dhn + (3.5 * sn)) /**/};
  
  double[] bass1_5 = {a2, en, e3, qn, a3, qn, e3, en, a3, en, e3, en, /**/ g2, en, d3, en,
    g3, en, g2, qn, e2, qn, g2, en, /**/ a2, en, e3, qn, a3, qn, e3, en, a3 ,en, e3, en, /**/
    g2, en, d3, en, g3, en, g2, qn, e2, qn, g2, en, /**/ a2, en, e3, qn, a3, qn, e3, en, 
    a3, en, e3, en /**/};
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  double[] treble6_9 = {rest, dqn, c5, en, b4, en, g4, en, d4, en, /**/ e4, (en + wn), /**/
    rest, dqn, a4, en, g4, en, e4, en, d4, en, c4, en, /**/ rest, en, g4, en, c5, en, 
    c5, sn, a4, (hn + sn) /**/};
 
  double[] trebleharm6_9 = {rest, hn, c3, qn, g3, qn,/**/ g3, sn, e3, sn, g3, sn, e3, sn, a3, qn, e3, hn, /**/
    rest, hn, a3, en, g3, en, e3, qn,/**/ e4, en, a4, en, c4, hn, c3, qn };
  
  double[] bass6_9 = {g2, en, d3, en, g3, en, g2, qn, e2, qn, g2, en, /**/ a1, en, e2, qn, 
    a3, qn, e3, en, a3, en, e3, en, /**/ g2, en, d3, en, g3, en, g2, qn, e2, qn, g2, en, /**/
    a1, en, e2, qn, a3, qn, e3, en, a3, en, e3, en /**/};
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
  double[] treble10_13 = {rest, dqn, c5, en, b4, en, g4, en, e4, en, /**/ d4, hn, g4 ,en,
    fs4, en, e4, en, d4, en, /**/ g3, qn, a3, qn, b3, (sn / 2), c4, (qn - (sn/2)), g3, en,
    a3, qn, /**/ a3, wn /**/};
  
  double[] trebleharm10_13 = {rest, en, b4, qn, rest, sn, a4, sn, c5, sn, e5, sn, e4, en, g4, en, rest, en, /**/ 
    d5, sn, c5, sn, b4, sn, e4, sn, g4, sn, a4, sn, g4, sn, e4, sn, g4, en, e4, en, d4, en, /**/ 
    c4, dqn, d4, en, d4, (sn / 2), c4, (qn - (sn/2)), b3, dqn, /**/ a4, en, c5, en, e5, sn, d5, sn, c5, sn,
    a4, en, b4, sn, a4, qn /**/};
  
  double[] bass10_13 = {g2, en, d3, en, g3, en, g2, qn, e2, qn, g2, en, /**/ d3, en, e3, qn, 
    a3, qn, e3, en, a3, en, e3, en, /**/ c3, en, e3, qn, a3, en, b2, en, e3, en, a3, en, e3, en,
    /**/ a2, en, e3, qn, a3, qn, e3, en, a3, en, e3, en /**/};
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
  double[] treble14_17 = {rest, dqn, c5, en, b4, en, g4, en, d4, en, /**/ e4, (hn + en),
    a4, (hn + dqn), /**/ a4, en, g4, en, e4, en, d4, en, c4, en, /**/ rest, en, g4, en, 
    rest, en, g4, (sn / 2), a4, (hn + (1.5 * sn)) /**/};
  
  double[] trebleharm14_17 = {rest, dqn, e5, sn, c5, sn, g5, dqn, rest, en, /**/ a5, sn, b5, sn, c6, en, 
    e6, dhn, /**/ g6, sn, fs6, sn, e6, en, e6, dhn, /**/ rest, qn, e6, en, c6, en, a5, sn, e5, sn, c5, en,
    a4, qn /**/};
  
  double[] bass14_17 = {g2, en, d3, en, g3, en, g2, qn, e2, qn, g2, en, /**/ a1, en, e2, qn, 
    a3, qn, e3, en, a3, en, e3, en, /**/ g2, en, d3, en, g3, en, g2, qn, e2, qn, g2, en, /**/
    a1, en, e2, qn, a3, qn, e3, en, a3, en, e3, en /**/};
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  double[] treble18_20 = {rest, dqn, c5, en, b4, en, g4, en, e4, en, /**/ d4, hn, g4, en,
    fs4, en, d4, en, e4, en, /**/ fs4, qn, a4, qn, b4, den, c5, sn, b4, en, a4, qn, /**/};
 
  double[] trebleharm18_20 = {rest, qn, c5, sn, e5, sn, g5, en, e6, dqn, fs6, sn, fs6, sn,/**/
    g6, sn, g6, sn, a6, dhn, rest, en, /**/ b6, (sn / 2), a6, (sn / 2), g6, (sn / 2), fs6, (sn / 2),
    e6, (sn / 2), d6, (sn / 2), c6, (sn / 2), b5, (sn / 2), a5, (sn / 2), g5, (sn / 2), fs5, (sn / 2),
    e5, (sn / 2), d5, (sn / 2), c5, (sn / 2), b4, (sn / 2), a4, (sn / 2), g4, sn, fs4, sn, e4, sn,
    d4, sn, e4, qn /**/};
  
  double[] bass18_20 = {g2, en, d3, en, g3, en, g2, qn, e2, qn, g2, en, /**/ d3, en, e3, qn,
    a3, qn, e3, en, a3, en, e3, en, /**/ c3, en, e3, qn, a3, en, b2, en, e3, en, a3, en, e3, en /**/};
  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
  
  public Phrase t_1_20(){
    Phrase phr = new Phrase();
   phr.addNoteList(treble1_5);
   phr.addNoteList(treble6_9);
   phr.addNoteList(treble10_13);
   phr.addNoteList(treble14_17);
   phr.addNoteList(treble18_20);
    return phr;
  }
  
  public Phrase b_1_20(){
    Phrase phr = new Phrase();
    phr.addNoteList(bass1_5);
    phr.addNoteList(bass6_9);
    phr.addNoteList(bass10_13);
    phr.addNoteList(bass14_17);
    phr.addNoteList(bass18_20);
    return phr;
  }
  
  public Phrase tH_1_20(){
    Phrase phr = new Phrase();
    phr.addNoteList(trebleharm1_5);
    phr.addNoteList(trebleharm6_9);
    phr.addNoteList(trebleharm10_13);
    phr.addNoteList(trebleharm14_17);
    phr.addNoteList(trebleharm18_20);
    return phr;
  }
  
  
  public static void main(String[] args){
    SoundtrackWorking test = new SoundtrackWorking();
    Score theme = new Score("StarCraftish");
  
    Part treble = new Part("Treble", JMC.SAWTOOTH, 1);
    treble.addPhrase(test.t_1_20());
    
    Part bass = new Part("Bass", JMC.SYNTH_BASS, 3);
    bass.addPhrase(test.b_1_20());
    
    Part harm1 = new Part("Harmony", JMC.SQUARE, 2);
    harm1.addPhrase(test.tH_1_20());
    
    theme.setTimeSignature(4,4);
    theme.addPart(treble);
    theme.addPart(bass);
    theme.addPart(harm1);
    theme.setTempo(130.0);
    Play.midi(theme);
    
    

    
    View.notate(theme);
    
  }
  
  }
  


