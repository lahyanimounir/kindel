package com.mycompany.kindleclient;

import java.io.IOException;
import java.text.ParseException;
import com.mycompany.kindleclient.config.ConfigSocket;
import com.mycompany.kindleclient.model.Etudiant;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mounir
 */
public class KindleClient {
    public static boolean  is_first = true;
    static ConfigSocket soc = new ConfigSocket();
    public static void main(String[] args) throws IOException, InterruptedException{
        
        
        /*Gestion_Client client = new Gestion_Client();
        String id_emprnt = client.login("mounir", "123456");*/
       /* Etudiant etd = new Etudiant("Soumia","123456","A123","Soumya","Talha","154","Math");

        String consult = soc.getSocket("user,add,"+etd);
        System.out.println("reponse " + consult);*/
       
       /* String reponse = soc.getSocket("getdocuments");
        System.out.println("reponse " + reponse);
        
       
        
        
        */
        
       /* 
       
       String title = "titreLivre";
        String consult = soc.getSocket("user,get");
        System.out.println("allusers " + consult);
        */
       
       String title = "titreLivre";
        /*String consult = soc.getSocket("user,getcin,"+"11");
        System.out.println("allusers " + consult);*/
        
        //ajout kindel
       /* String consult = soc.getSocket("kindle,add,model,mac,"+15);
        System.out.println("allusers " + consult);*/
       
        //String bye = soc.getSocket("bye");
        
       
       System.out.println("=====================================  Bievenue à l'application de gestion des kindel =========================================  ");
       System.out.println("==================================  Merci de ce connecter pour accéder a l'application =========================================");
       Scanner scanner = new Scanner(System.in);
       System.out.println("2 --> login :");
       String login = scanner.nextLine();
       System.out.println("2 --> password :");
       String password = scanner.nextLine();
      
       Gestion_Client client = new Gestion_Client();
       String role = client.login(login, password);
       
       String roleClient = role.split(",")[0];
       
      String choix="";
        
       
        do{
            if(is_first){
               choix = principal_menu(roleClient); 
            }
            if(role.equals("gerant")){
                if(choix.equals("1")){
                    addUser();
                }
                else if(choix.equals("2")){
                    deleteUser();
                }else if(choix.equals("3")){
                    updateUser();
                }else if(choix.equals("4")){
                    getUserCin();
                }else if(choix.equals("5")){
                    retourKindel();
                }
                else if(choix.equals("6")){
                    addkindel();
                }
                else if(choix.equals("7")){
                    modifierKindel();
                }
                 else if(choix.equals("8")){
                    deletekindel();
                } else if(choix.equals("9")){
                    getAllusers();
                } 
                else if(choix.equals("10")){
                    AddLivre();
                }
                 else if(choix.equals("11")){
                    updateLivre();
                } else if(choix.equals("12")){
                    deleteLivre();
                } 
            }else{
                if(choix.equals("1")){
                    showAllDocs();
                }
                if(choix.equals("2")){
                    consulteLivre(role.split(",")[1]);
                }
            }
            if(choix.equals("99")){
                System.out.println("========================================  Au revoir =========================================");
                break;
            }
        }while(true);
       
        
       
        
        
        
        
      /* */
       
       
       
      // String type = "Professeur";
        // String type = "Gerant";
        
       /* String etd = "aaa,aa,aa,aa,aa,222,aa";

        String useradd = soc.getSocket("user,add,Professeur,"+etd);
        System.out.println("reponse " + useradd);
        
        String bye = soc.getSocket("bye");*/
       
       
    }
    
    public static void consulteLivre(String id_emprunt) throws IOException{
          Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter le titre Livre a Consulter");
        String title = scanner.nextLine(); 
        String consult = soc.getSocket("consultdoc,"+title+","+id_emprunt);
        System.out.println("vous avez reserver le livre avec succée bon lecture");
    }
    
    public static String principal_menu(String role){
            String choix="";
            Scanner scanner = new Scanner(System.in);
          if(role.equals("gerant")){
        System.out.println("=====================================  Bievenue à l'application de gestion des utilisateur =========================================  ");
        System.out.println("1 --> Ajouter utilisateur");
        System.out.println("2 --> Supprimer Utilisateur");
        System.out.println("3 --> Modifier utilisateur");
        System.out.println("4 --> Chercher utilisateur par CIN");
        System.out.println("9 --> Voir la liste des utilisateurs ");
        System.out.println("5 --> Libérez kindel");
        System.out.println("6 --> Ajouter kindel");
        System.out.println("7 --> Modifier kindel");
        System.out.println("8 --> Supprimer kindel");
        System.out.println("10 --> Ajouter Livre");
        System.out.println("11 --> Modifier Livre");
        System.out.println("12 --> Supprimer Livre");
        System.out.println("0 --> Retour au menu");        
        System.out.println("99 --> logOut");

        choix = scanner.nextLine();
       }else{
            System.out.println("=====================================  Bievenue a la bibliotheque =========================================  ");
            System.out.println("1 -->Afficher tous les livres");
            System.out.println("2 --> Consulter un livre");
            System.out.println("0 --> Retour au menu");
            System.out.println("99 --> logOut");
            choix = scanner.nextLine();
       }
          return choix;
        
    }
    
    
        public static void deleteLivre() throws IOException{
             
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter l'id du Livre a Supprimer");
        int id_kindel = scanner.nextInt(); 
        String consult = soc.getSocket("livre,delete,"+id_kindel);
        System.out.println("allusers " + consult);

      is_first = true;   
        
    }
    
        public static void showAllDocs() throws IOException{
            String reponse = soc.getSocket("getdocuments");
            System.out.print(reponse);
        }
        
        public static void AddLivre() throws IOException{
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Merci d'enter le Titre");
        String titre = scanner.nextLine(); 
        System.out.println("Merci d'enter l'adresse Editeur");
        String editeur = scanner.nextLine(); 
        
        System.out.println("Merci d'enter Edition");
        int edition = scanner.nextInt(); 
        System.out.println("Merci d'enter le isbn");
        String isbn = scanner.nextLine(); 
        isbn = scanner.nextLine(); 
        
        System.out.println("Merci d'enter auteurs");
        String auteurs = scanner.nextLine(); 
        System.out.println("Merci d'enter l'url");
        String url = scanner.nextLine(); 
        System.out.println("Merci d'enter le nbPages");
        int nbPages = scanner.nextInt(); 
        System.out.println("Merci d'enter type de document");
        String type_doc = scanner.nextLine(); 
        type_doc = scanner.nextLine();
        
        String consult = soc.getSocket("livre,add,"+titre+","+editeur+","+edition+","+isbn+","+auteurs+","+url+","+nbPages+","+type_doc);
        System.out.println("Add livre " + consult);
        is_first = true;
        }
        
        
        public static void updateLivre() throws IOException{
       Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter id du livre a modifier");
        int id_livre = scanner.nextInt(); 

        System.out.println("Merci d'enter le Titre");
        String titre = scanner.nextLine(); 
        titre = scanner.nextLine();
        System.out.println("Merci d'enter l'adresse Editeur");
        String editeur = scanner.nextLine(); 
        
        System.out.println("Merci d'enter Edition");
        int edition = scanner.nextInt(); 
        System.out.println("Merci d'enter le isbn");
        String isbn = scanner.nextLine(); 
        
        isbn = scanner.nextLine(); 
        System.out.println("Merci d'enter auteurs");
        String auteurs = scanner.nextLine(); 
        System.out.println("Merci d'enter l'url");
        String url = scanner.nextLine(); 
        System.out.println("Merci d'enter le nbPages");
        int nbPages = scanner.nextInt(); 
        System.out.println("Merci d'enter type de document");
        String type_doc = scanner.nextLine(); 
        type_doc = scanner.nextLine();
        
        String consult = soc.getSocket("livre,update,"+titre+","+editeur+","+edition+","+auteurs+","+isbn+","+url+","+nbPages+","+type_doc+","+id_livre);
        System.out.println("Update livre " + consult);
        is_first = true;
        }
        
        
    
     public static void addkindel() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter le model");
        String model = scanner.nextLine(); 
        System.out.println("Merci d'enter l'adresse MAC");
        String mac = scanner.nextLine(); 
        System.out.println("Merci la taille en pouce");
        int pouce = scanner.nextInt(); 
        
        String consult = soc.getSocket("kindle,add,"+model+","+mac+","+pouce);
        System.out.println("allusers " + consult);
        is_first = true;
    }
       
          public static void deletekindel() throws IOException{
             
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Merci d'enter l'id du Kindel a Supprimer");
                    int id_kindel = scanner.nextInt(); 
                    String consult = soc.getSocket("kindle,delete,"+id_kindel);
                    System.out.println("allusers " + consult);
            
                  is_first = true;
              
     
        
    }
       
         public static void modifierKindel() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter l'id du Kindel a modifier");
        int id_kindel = scanner.nextInt(); 
        System.out.println("Merci d'enter le model");
            String model = scanner.nextLine(); 
            model = scanner.nextLine(); 
        System.out.println("Merci d'enter l'adresse MAC");
        String mac = scanner.nextLine(); 
        System.out.println("Merci la taille en pouce");
        int pouce = scanner.nextInt(); 
        String consult = soc.getSocket("kindle,update,"+id_kindel+","+model+","+mac+","+pouce);
        System.out.println("allusers " + consult);
        is_first = true;
    }
         
         
                 
    public static void getAllusers() throws IOException{
        
        String consult = soc.getSocket("user,get");
        System.out.println(consult);
        is_first = true;
    }
    
      public static void retourKindel() throws IOException{
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter l'id du Kindel");
        int id_kindel = scanner.nextInt();  
         System.out.println("Merci d'enter l'id d'emprunt");
        int id_emprunt = scanner.nextInt(); 
        String date_retour="2021-06-06";
                        
        String consult = soc.getSocket("kindle,retour,"+id_kindel+","+date_retour+","+id_emprunt);
         
        is_first = true;
    }
    
    public static void getUserCin() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter le CIN de l'utilisateur que vous rechérchez");
        String cin = scanner.nextLine();  
         String consult = soc.getSocket("user,getcin,"+cin);
        System.out.println("l'utilisateur est : " + consult);
        is_first = true;
    }
    
   
    public static void deleteUser() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter d'id de l'utilisateur a supprimer");
        int id_user = scanner.nextInt();
        is_first = true;
        String useradd = soc.getSocket("user,delete,"+id_user);
    }
    
      public static void updateUser() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Merci d'enter d'id de l'utilisateur a modifier");
        int id_user = scanner.nextInt();            
        
            System.out.println("======= Merci de choisir le type de l\"utilisateur=====");             
             System.out.println("1 --> Professeur");             
             System.out.println("2 --> Gerant");             
             System.out.println("3 --> Etudiant");
             System.out.println("0 --> Retour au menu");
             String choix = scanner.nextLine();            
              choix = scanner.nextLine();

                 String type="";
                 if(choix.equals("1")){
                     type = "Professeur";
                 }else if(choix.equals("2")){
                     type = "gerant";
                 }else if(choix.equals("3")){
                     type = "etudiant";
                 }else if(choix.equals("0")){
                     is_first = true;
                 }
             
            
            System.out.println("Username");   
            String username = scanner.nextLine();            
          

            System.out.println("Password"); 
            String password = scanner.nextLine();
            System.out.println("Cin");  
            String cin = scanner.nextLine();
            System.out.println("Nom");  
            String nom = scanner.nextLine();
            System.out.println("Prenom");  
            String prenom = scanner.nextLine();
            System.out.println("matricule");
            int matricule = scanner.nextInt();
        
        String prof = username+","+password+","+cin+","+nom+","+prenom+","+matricule;
        
                
        is_first = true;
        String useradd = soc.getSocket("user,update,"+id_user+","+type+","+prof);
    }
    
     public static String addUser() throws IOException{
        String choix="";
            Scanner scanner = new Scanner(System.in);
             System.out.println("======= Merci de choisir le type de l\"utilisateur=====");             
             System.out.println("1 --> Professeur");             
             System.out.println("2 --> Gerant");             
             System.out.println("3 --> Etudiant");
             System.out.println("0 --> Retour au menu");
             choix = scanner.nextLine();
            
             if(choix.equals("0")){
                 is_first = true;
             }else if(choix.equals("1")){
                 
                 String type = "Professeur";
                // String type = "Gerant";
                System.out.println("Username");   
                String username = scanner.nextLine();
                System.out.println("Password"); 
                String password = scanner.nextLine();
                System.out.println("Cin");  
                String cin = scanner.nextLine();
                System.out.println("Nom");  
                String nom = scanner.nextLine();
                System.out.println("Prenom");  
                String prenom = scanner.nextLine();
                System.out.println("matricule");
                int matricule = scanner.nextInt();

                String prof = username+","+password+","+cin+","+nom+","+prenom+","+matricule;
                String useradd = soc.getSocket("user,add,"+type+","+prof);
                System.out.print(useradd);
        
             }
             else if(choix.equals("2")){
      
                 String type = "Gerant";
                // String type = "Gerant";
                System.out.println("Username");   
                String username = scanner.nextLine();
                System.out.println("Password"); 
                String password = scanner.nextLine();
                System.out.println("Cin");  
                String cin = scanner.nextLine();
                System.out.println("Nom");  
                String nom = scanner.nextLine();
                System.out.println("Prenom");  
                String prenom = scanner.nextLine();

                String prof = username+","+password+","+cin+","+nom+","+prenom;
                String useradd = soc.getSocket("user,add,"+type+","+prof);
                System.out.print(useradd);
        
             }
             else if(choix.equals("3")){
                 
                 String type = "Etudiant";
                // String type = "Gerant";
                System.out.println("Username");   
                String username = scanner.nextLine();
                System.out.println("Password"); 
                String password = scanner.nextLine();
                System.out.println("Cin");  
                String cin = scanner.nextLine();
                System.out.println("Nom");  
                String nom = scanner.nextLine();
                System.out.println("Prenom");  
                String prenom = scanner.nextLine();
                System.out.println("Cne");  
                String cne = scanner.nextLine();
                System.out.println("Fillier");  
                String fillier = scanner.nextLine();

                String prof = username+","+password+","+cin+","+nom+","+prenom+","+cne+","+fillier;
                String useradd = soc.getSocket("user,add,"+type+","+prof);
                System.out.print(useradd);
        
             }
          return choix;
     }
   
    
}
