      SUBROUTINE systim_  (JULIAN, ISECONDS)
C
C     Interface routine to call HECLIB routine SYSTIM
C
      INTEGER*4 JULIAN !![REFERENCE]
      INTEGER   ISECONDS !![REFERENCE]
C
      CALL SYSTIM (JULIAN, ISECONDS)
C
      RETURN
      END
