��    '      T  5   �      `  B   a  !  �  �  �  9   �  M   �     ?     Y  ,   s     �  %   �  ,   �  -   	      ?	  &   `	     �	     �	  e   �	  :   -
    h
  �  �  �  a     �     	  *     1   E  &   w     �  "   �  9   �  I     �   Z     �          !     2     D     S     f  �  r  X   E  s  �  �    M   �  a   "  )   �  ,   �  G   �  :   #  :   ^  G   �  F   �  =   (  7   f  /   �  /   �  �   �  b   �  �  �  E  �  C  3#  #   w%     �%  @   �%  R   �%  A   E&  2   �&  >   �&  a   �&  s   ['    �'     �(  )   )  #   ,)  %   P)     v)  #   �)     �)                                          $                                    %   
                            #                             '         &             !   	          "      -V, --version               output version information and exit
   -d, --domain=TEXTDOMAIN   retrieve translated message from TEXTDOMAIN
  -e                        enable expansion of some escape sequences
  -E                        (ignored for compatibility)
  -h, --help                display this help and exit
  -V, --version             display version information and exit
  [TEXTDOMAIN]              retrieve translated message from TEXTDOMAIN
  MSGID MSGID-PLURAL        translate MSGID (singular) / MSGID-PLURAL (plural)
  COUNT                     choose singular/plural form based on this value
   -d, --domain=TEXTDOMAIN   retrieve translated messages from TEXTDOMAIN
  -e                        enable expansion of some escape sequences
  -E                        (ignored for compatibility)
  -h, --help                display this help and exit
  -n                        suppress trailing newline
  -V, --version             display version information and exit
  [TEXTDOMAIN] MSGID        retrieve translated message corresponding
                            to MSGID from TEXTDOMAIN
   -h, --help                  display this help and exit
   -v, --variables             output the variables occurring in SHELL-FORMAT
 %s: illegal option -- %c
 %s: invalid option -- %c
 %s: option `%c%s' doesn't allow an argument
 %s: option `%s' is ambiguous
 %s: option `%s' requires an argument
 %s: option `--%s' doesn't allow an argument
 %s: option `-W %s' doesn't allow an argument
 %s: option `-W %s' is ambiguous
 %s: option requires an argument -- %c
 %s: unrecognized option `%c%s'
 %s: unrecognized option `--%s'
 Display native language translation of a textual message whose grammatical
form depends on a number.
 Display native language translation of a textual message.
 If the TEXTDOMAIN parameter is not given, the domain is determined from the
environment variable TEXTDOMAIN.  If the message catalog is not found in the
regular directory, another location can be specified with the environment
variable TEXTDOMAINDIR.
Standard search directory: %s
 If the TEXTDOMAIN parameter is not given, the domain is determined from the
environment variable TEXTDOMAIN.  If the message catalog is not found in the
regular directory, another location can be specified with the environment
variable TEXTDOMAINDIR.
When used with the -s option the program behaves like the `echo' command.
But it does not simply copy its arguments to stdout.  Instead those messages
found in the selected catalog are translated.
Standard search directory: %s
 In normal operation mode, standard input is copied to standard output,
with references to environment variables of the form $VARIABLE or ${VARIABLE}
being replaced with the corresponding values.  If a SHELL-FORMAT is given,
only those environment variables that are referenced in SHELL-FORMAT are
substituted; otherwise all environment variables references occurring in
standard input are substituted.
 Informative output:
 Operation mode:
 Report bugs to <bug-gnu-gettext@gnu.org>.
 Substitutes the values of environment variables.
 Try `%s --help' for more information.
 Unknown system error Usage: %s [OPTION] [SHELL-FORMAT]
 Usage: %s [OPTION] [TEXTDOMAIN] MSGID MSGID-PLURAL COUNT
 Usage: %s [OPTION] [[TEXTDOMAIN] MSGID]
or:    %s [OPTION] -s [MSGID]...
 When --variables is used, standard input is ignored, and the output consists
of the environment variables that are referenced in SHELL-FORMAT, one per line.
 Written by %s.
 error while reading "%s" memory exhausted missing arguments standard input too many arguments write error Project-Id-Version: gettext-runtime 0.13-pre1
Report-Msgid-Bugs-To: bug-gnu-gettext@gnu.org
POT-Creation-Date: 2007-11-02 03:22+0100
PO-Revision-Date: 2003-11-18 23:48+0100
Last-Translator: Danilo Segan <dsegan@gmx.net>
Language-Team: Serbian <sr@li.org>
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
Plural-Forms: nplurals=3;    plural=n%10==1 && n%100!=11 ? 0 :  (n%10>=2 && n%10<=4 && (n%100<10 || n%100>=20) ? 1 : 2);
   -V, --version               испиши податке о издању и изађи
   -d, --domain=ДОМЕНТЕКСТА  користи преведене поруке из ДОМЕНТЕКСТА
  -e                        укључи употребу неких нарочитих низова
  -E                        (занемарено ради сагласности)
  -h, --help                прикажи ову помоћ па изађи
  -n                        одбаци пратећи знак за нови ред
  -V, --version             прикажи податке о издању па изађи
  [ДОМЕНТЕКСТА]             користи преведену поруку из ДОМЕНТЕКСТА
  MSGID MSGID-МНОЖИНА       преведи облик једнине/множине
  БРОЈ                      изабери облик једнине/множине према овој вредности
   -d, --domain=ДОМЕНТЕКСТА  користи преведене поруке из ДОМЕНТЕКСТА
  -e                        укључи употребу неких нарочитих низова
  -E                        (занемарено ради сагласности)
  -h, --help                прикажи ову помоћ па изађи
  -n                        одбаци пратећи знак за нови ред
  -V, --version             прикажи податке о издању па изађи
  [ДОМЕНТЕКСТА] MSGID       користи преведену поруку за MSGID из 
                            ДОМЕНТЕКСТА
   -h, --help                  прикажи ову помоћ и изађи
   -v, --variables             исписује променљиве из ФОРМАТ-ЉУСКЕ
 %s: неисправна опција %c
 %s: неисправна опција -- %c
 %s: опција „%c%s“ не дозвољава аргументе
 %s: опција „%s“ није једнозначна
 %s: опција „%s“ захтева аргумент
 %s: опција „--%s“ не дозвољава аргументе
 %s: опција „-W %s“ не дозвољава аргумент
 %s: опција „-W %s“ није једнозначна
 %s: опција захтева аргумент -- %c
 %s: непозната опција „%c%s“
 %s: непозната опција „--%s“
 Прикажи превод у природном језику за текстуалну поруку чији 
облик зависи од броја.
 Прикажи превод текстуалне поруке у природном језику.
 Уколико није дат параметар ДОМЕНТЕКСТА, домен се одређује на основу 
променљиве окружења TEXTDOMAIN.  Уколико не може да нађе каталог порука 
у обичном директоријуму, други директоријум се може навести помоћу 
променљиве окружења TEXTDOMAINDIR.
Уобичајени директоријум за тражење: %s
 Уколико није дат параметар ДОМЕНТЕКСТА, домен се одређује на основу 
променљиве окружења TEXTDOMAIN.  Уколико не може да нађе каталог порука 
у обичном директоријуму, други директоријум се може навести помоћу 
променљиве окружења TEXTDOMAINDIR.
Када се користи уз опцију -s, програм се понаша као „echo“ наредба.
Међутим, он не пребацује само своје аргументе на излаз. Уместо тога, поруке 
које постоје у изабраном каталогу се преводе.
Уобичајени директоријум за тражење: %s
 При обичном раду, стандардни улаз се копира на стандардни излаз, уз замену
променљивих из окружења облика $ПРОМЕНЉИВА или ${ПРОМЕНЉИВА} одговарајућим
вредностима. Ако је дат ФОРМАТ-ЉУСКЕ, само оне променљиве које су у њему
наведене се замењују; иначе, све променљиве окружења наведене у стандардном
улазу се замењују.
 Обавештајни излаз:
 Начин рада:
 Пријавите грешке на <bug-gnu-gettext@gnu.org>.
 Замењује вредности променљивих из окружења.
 Пробајте „%s --help“ за више података.
 Непозната системска грешка Употреба: %s [ОПЦИЈА] [ФОРМАТ-ЉУСКЕ]
 Употреба: %s [ОПЦИЈА] [ДОМЕНТЕКСТА] MSGID MSGID-МНОЖИНА БРОЈ
 Употреба: %s [ОПЦИЈА] [[ДОМЕН ТЕКСТА] MSGID]
или:      %s [ОПЦИЈА] -s [MSGID]...
 Када се користи --variables, занемарује се стандардни улаз, а излаз се састоји 
из променљивих окружења које се помињу у ФОРМАТ-ЉУСКЕ, једна променљива по реду.
 Написао је %s.
 грешка при читању „%s“ меморија исцрпљена недостају аргументи стандардни улаз превише аргумената грешка при упису 