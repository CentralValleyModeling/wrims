      SUBROUTINE zsits_   (IFLTAB, CPATH, ITIMES, VALUES,
     * NVALS, IBDATE, CUNITS, CTYPE, INFLAG, ISTAT,
     * L_CPATH, L_CUNITS, L_CTYPE)
C
      INTEGER   IFLTAB !![REFERENCE]
      CHARACTER CPATH  !![REFERENCE]
      INTEGER   ITIMES !![REFERENCE]
      REAL      VALUES !![REFERENCE]
      INTEGER   NVALS  !![REFERENCE]
      INTEGER   IBDATE !![REFERENCE]
      CHARACTER CUNITS !![REFERENCE]
      CHARACTER CTYPE  !![REFERENCE]
      INTEGER   INFLAG !![REFERENCE]
      INTEGER   ISTAT  !![REFERENCE]
      INTEGER L_CPATH  !![VALUE]
      INTEGER L_CUNITS !![VALUE]
      INTEGER L_CTYPE  !![VALUE]
C
      CALL  ZSITS (IFLTAB, CPATH(1:L_CPATH), ITIMES, VALUES, NVALS,
     * IBDATE, CUNITS(1:L_CUNITS), CTYPE(1:L_CTYPE), INFLAG, ISTAT)
C
      RETURN
      END
