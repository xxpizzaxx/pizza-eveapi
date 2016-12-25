package moe.pizza.sdeapi
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = Array(Agtagents.schema, Agtagenttypes.schema, Agtresearchagents.schema, Certcerts.schema, Certmasteries.schema, Certskills.schema, Chrancestries.schema, Chrattributes.schema, Chrbloodlines.schema, Chrfactions.schema, Chrraces.schema, Crpactivities.schema, Crpnpccorporationdivisions.schema, Crpnpccorporationresearchfields.schema, Crpnpccorporations.schema, Crpnpccorporationtrades.schema, Crpnpcdivisions.schema, Dgmattributecategories.schema, Dgmattributetypes.schema, Dgmeffects.schema, Dgmexpressions.schema, Dgmtypeattributes.schema, Dgmtypeeffects.schema, Evegraphics.schema, Eveicons.schema, Eveunits.schema, Industryactivity.schema, Industryactivitymaterials.schema, Industryactivityprobabilities.schema, Industryactivityproducts.schema, Industryactivityskills.schema, Industryblueprints.schema, Invcategories.schema, Invcontrabandtypes.schema, Invcontroltowerresourcepurposes.schema, Invcontroltowerresources.schema, Invflags.schema, Invgroups.schema, Invitems.schema, Invmarketgroups.schema, Invmetagroups.schema, Invmetatypes.schema, Invnames.schema, Invpositions.schema, Invtraits.schema, Invtypematerials.schema, Invtypereactions.schema, Invtypes.schema, Invuniquenames.schema, Mapcelestialstatistics.schema, Mapconstellationjumps.schema, Mapconstellations.schema, Mapdenormalize.schema, Mapjumps.schema, Maplandmarks.schema, Maplocationscenes.schema, Maplocationwormholeclasses.schema, Mapregionjumps.schema, Mapregions.schema, Mapsolarsystemjumps.schema, Mapsolarsystems.schema, Mapuniverse.schema, Planetschematics.schema, Planetschematicspinmap.schema, Planetschematicstypemap.schema, Ramactivities.schema, Ramassemblylinestations.schema, Ramassemblylinetypedetailpercategory.schema, Ramassemblylinetypedetailpergroup.schema, Ramassemblylinetypes.schema, Raminstallationtypecontents.schema, Skinlicense.schema, Skinmaterials.schema, Skins.schema, Skinship.schema, Staoperations.schema, Staoperationservices.schema, Staservices.schema, Stastations.schema, Stastationtypes.schema, Translationtables.schema, Trntranslationcolumns.schema, Trntranslationlanguages.schema, Trntranslations.schema, Warcombatzones.schema, Warcombatzonesystems.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Agtagents
   *  @param agentid Database column agentID SqlType(INT), PrimaryKey
   *  @param divisionid Database column divisionID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param corporationid Database column corporationID SqlType(INT), Default(None)
   *  @param locationid Database column locationID SqlType(INT), Default(None)
   *  @param level Database column level SqlType(TINYINT UNSIGNED), Default(None)
   *  @param quality Database column quality SqlType(SMALLINT), Default(None)
   *  @param agenttypeid Database column agentTypeID SqlType(INT), Default(None)
   *  @param islocator Database column isLocator SqlType(BIT), Default(None) */
  case class AgtagentsRow(agentid: Int, divisionid: Option[Byte] = None, corporationid: Option[Int] = None, locationid: Option[Int] = None, level: Option[Byte] = None, quality: Option[Short] = None, agenttypeid: Option[Int] = None, islocator: Option[Boolean] = None)
  /** GetResult implicit for fetching AgtagentsRow objects using plain SQL queries */
  implicit def GetResultAgtagentsRow(implicit e0: GR[Int], e1: GR[Option[Byte]], e2: GR[Option[Int]], e3: GR[Option[Short]], e4: GR[Option[Boolean]]): GR[AgtagentsRow] = GR{
    prs => import prs._
    AgtagentsRow.tupled((<<[Int], <<?[Byte], <<?[Int], <<?[Int], <<?[Byte], <<?[Short], <<?[Int], <<?[Boolean]))
  }
  /** Table description of table agtAgents. Objects of this class serve as prototypes for rows in queries. */
  class Agtagents(_tableTag: Tag) extends Table[AgtagentsRow](_tableTag, "agtAgents") {
    def * = (agentid, divisionid, corporationid, locationid, level, quality, agenttypeid, islocator) <> (AgtagentsRow.tupled, AgtagentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(agentid), divisionid, corporationid, locationid, level, quality, agenttypeid, islocator).shaped.<>({r=>import r._; _1.map(_=> AgtagentsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column agentID SqlType(INT), PrimaryKey */
    val agentid: Rep[Int] = column[Int]("agentID", O.PrimaryKey)
    /** Database column divisionID SqlType(TINYINT UNSIGNED), Default(None) */
    val divisionid: Rep[Option[Byte]] = column[Option[Byte]]("divisionID", O.Default(None))
    /** Database column corporationID SqlType(INT), Default(None) */
    val corporationid: Rep[Option[Int]] = column[Option[Int]]("corporationID", O.Default(None))
    /** Database column locationID SqlType(INT), Default(None) */
    val locationid: Rep[Option[Int]] = column[Option[Int]]("locationID", O.Default(None))
    /** Database column level SqlType(TINYINT UNSIGNED), Default(None) */
    val level: Rep[Option[Byte]] = column[Option[Byte]]("level", O.Default(None))
    /** Database column quality SqlType(SMALLINT), Default(None) */
    val quality: Rep[Option[Short]] = column[Option[Short]]("quality", O.Default(None))
    /** Database column agentTypeID SqlType(INT), Default(None) */
    val agenttypeid: Rep[Option[Int]] = column[Option[Int]]("agentTypeID", O.Default(None))
    /** Database column isLocator SqlType(BIT), Default(None) */
    val islocator: Rep[Option[Boolean]] = column[Option[Boolean]]("isLocator", O.Default(None))

    /** Index over (corporationid) (database name agtAgents_IX_corporation) */
    val index1 = index("agtAgents_IX_corporation", corporationid)
    /** Index over (locationid) (database name agtAgents_IX_station) */
    val index2 = index("agtAgents_IX_station", locationid)
  }
  /** Collection-like TableQuery object for table Agtagents */
  lazy val Agtagents = new TableQuery(tag => new Agtagents(tag))

  /** Entity class storing rows of table Agtagenttypes
   *  @param agenttypeid Database column agentTypeID SqlType(INT), PrimaryKey
   *  @param agenttype Database column agentType SqlType(VARCHAR), Length(50,true), Default(None) */
  case class AgtagenttypesRow(agenttypeid: Int, agenttype: Option[String] = None)
  /** GetResult implicit for fetching AgtagenttypesRow objects using plain SQL queries */
  implicit def GetResultAgtagenttypesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[AgtagenttypesRow] = GR{
    prs => import prs._
    AgtagenttypesRow.tupled((<<[Int], <<?[String]))
  }
  /** Table description of table agtAgentTypes. Objects of this class serve as prototypes for rows in queries. */
  class Agtagenttypes(_tableTag: Tag) extends Table[AgtagenttypesRow](_tableTag, "agtAgentTypes") {
    def * = (agenttypeid, agenttype) <> (AgtagenttypesRow.tupled, AgtagenttypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(agenttypeid), agenttype).shaped.<>({r=>import r._; _1.map(_=> AgtagenttypesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column agentTypeID SqlType(INT), PrimaryKey */
    val agenttypeid: Rep[Int] = column[Int]("agentTypeID", O.PrimaryKey)
    /** Database column agentType SqlType(VARCHAR), Length(50,true), Default(None) */
    val agenttype: Rep[Option[String]] = column[Option[String]]("agentType", O.Length(50,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Agtagenttypes */
  lazy val Agtagenttypes = new TableQuery(tag => new Agtagenttypes(tag))

  /** Entity class storing rows of table Agtresearchagents
   *  @param agentid Database column agentID SqlType(INT)
   *  @param typeid Database column typeID SqlType(INT) */
  case class AgtresearchagentsRow(agentid: Int, typeid: Int)
  /** GetResult implicit for fetching AgtresearchagentsRow objects using plain SQL queries */
  implicit def GetResultAgtresearchagentsRow(implicit e0: GR[Int]): GR[AgtresearchagentsRow] = GR{
    prs => import prs._
    AgtresearchagentsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table agtResearchAgents. Objects of this class serve as prototypes for rows in queries. */
  class Agtresearchagents(_tableTag: Tag) extends Table[AgtresearchagentsRow](_tableTag, "agtResearchAgents") {
    def * = (agentid, typeid) <> (AgtresearchagentsRow.tupled, AgtresearchagentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(agentid), Rep.Some(typeid)).shaped.<>({r=>import r._; _1.map(_=> AgtresearchagentsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column agentID SqlType(INT) */
    val agentid: Rep[Int] = column[Int]("agentID")
    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")

    /** Primary key of Agtresearchagents (database name agtResearchAgents_PK) */
    val pk = primaryKey("agtResearchAgents_PK", (agentid, typeid))

    /** Index over (typeid) (database name agtResearchAgents_IX_type) */
    val index1 = index("agtResearchAgents_IX_type", typeid)
  }
  /** Collection-like TableQuery object for table Agtresearchagents */
  lazy val Agtresearchagents = new TableQuery(tag => new Agtresearchagents(tag))

  /** Entity class storing rows of table Certcerts
   *  @param certid Database column certID SqlType(INT), PrimaryKey
   *  @param description Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param groupid Database column groupID SqlType(INT), Default(None)
   *  @param name Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
  case class CertcertsRow(certid: Int, description: Option[String] = None, groupid: Option[Int] = None, name: Option[String] = None)
  /** GetResult implicit for fetching CertcertsRow objects using plain SQL queries */
  implicit def GetResultCertcertsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[CertcertsRow] = GR{
    prs => import prs._
    CertcertsRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table certCerts. Objects of this class serve as prototypes for rows in queries. */
  class Certcerts(_tableTag: Tag) extends Table[CertcertsRow](_tableTag, "certCerts") {
    def * = (certid, description, groupid, name) <> (CertcertsRow.tupled, CertcertsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(certid), description, groupid, name).shaped.<>({r=>import r._; _1.map(_=> CertcertsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column certID SqlType(INT), PrimaryKey */
    val certid: Rep[Int] = column[Int]("certID", O.PrimaryKey)
    /** Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column groupID SqlType(INT), Default(None) */
    val groupid: Rep[Option[Int]] = column[Option[Int]]("groupID", O.Default(None))
    /** Database column name SqlType(VARCHAR), Length(255,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(255,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Certcerts */
  lazy val Certcerts = new TableQuery(tag => new Certcerts(tag))

  /** Entity class storing rows of table Certmasteries
   *  @param typeid Database column typeID SqlType(INT), Default(None)
   *  @param masterylevel Database column masteryLevel SqlType(INT), Default(None)
   *  @param certid Database column certID SqlType(INT), Default(None) */
  case class CertmasteriesRow(typeid: Option[Int] = None, masterylevel: Option[Int] = None, certid: Option[Int] = None)
  /** GetResult implicit for fetching CertmasteriesRow objects using plain SQL queries */
  implicit def GetResultCertmasteriesRow(implicit e0: GR[Option[Int]]): GR[CertmasteriesRow] = GR{
    prs => import prs._
    CertmasteriesRow.tupled((<<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table certMasteries. Objects of this class serve as prototypes for rows in queries. */
  class Certmasteries(_tableTag: Tag) extends Table[CertmasteriesRow](_tableTag, "certMasteries") {
    def * = (typeid, masterylevel, certid) <> (CertmasteriesRow.tupled, CertmasteriesRow.unapply)

    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))
    /** Database column masteryLevel SqlType(INT), Default(None) */
    val masterylevel: Rep[Option[Int]] = column[Option[Int]]("masteryLevel", O.Default(None))
    /** Database column certID SqlType(INT), Default(None) */
    val certid: Rep[Option[Int]] = column[Option[Int]]("certID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Certmasteries */
  lazy val Certmasteries = new TableQuery(tag => new Certmasteries(tag))

  /** Entity class storing rows of table Certskills
   *  @param certid Database column certID SqlType(INT), Default(None)
   *  @param skillid Database column skillID SqlType(INT), Default(None)
   *  @param certlevelint Database column certLevelInt SqlType(INT), Default(None)
   *  @param skilllevel Database column skillLevel SqlType(INT), Default(None)
   *  @param certleveltext Database column certLevelText SqlType(VARCHAR), Length(8,true), Default(None) */
  case class CertskillsRow(certid: Option[Int] = None, skillid: Option[Int] = None, certlevelint: Option[Int] = None, skilllevel: Option[Int] = None, certleveltext: Option[String] = None)
  /** GetResult implicit for fetching CertskillsRow objects using plain SQL queries */
  implicit def GetResultCertskillsRow(implicit e0: GR[Option[Int]], e1: GR[Option[String]]): GR[CertskillsRow] = GR{
    prs => import prs._
    CertskillsRow.tupled((<<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table certSkills. Objects of this class serve as prototypes for rows in queries. */
  class Certskills(_tableTag: Tag) extends Table[CertskillsRow](_tableTag, "certSkills") {
    def * = (certid, skillid, certlevelint, skilllevel, certleveltext) <> (CertskillsRow.tupled, CertskillsRow.unapply)

    /** Database column certID SqlType(INT), Default(None) */
    val certid: Rep[Option[Int]] = column[Option[Int]]("certID", O.Default(None))
    /** Database column skillID SqlType(INT), Default(None) */
    val skillid: Rep[Option[Int]] = column[Option[Int]]("skillID", O.Default(None))
    /** Database column certLevelInt SqlType(INT), Default(None) */
    val certlevelint: Rep[Option[Int]] = column[Option[Int]]("certLevelInt", O.Default(None))
    /** Database column skillLevel SqlType(INT), Default(None) */
    val skilllevel: Rep[Option[Int]] = column[Option[Int]]("skillLevel", O.Default(None))
    /** Database column certLevelText SqlType(VARCHAR), Length(8,true), Default(None) */
    val certleveltext: Rep[Option[String]] = column[Option[String]]("certLevelText", O.Length(8,varying=true), O.Default(None))

    /** Index over (certid) (database name ix_certSkills_certID) */
    val index1 = index("ix_certSkills_certID", certid)
  }
  /** Collection-like TableQuery object for table Certskills */
  lazy val Certskills = new TableQuery(tag => new Certskills(tag))

  /** Entity class storing rows of table Chrancestries
   *  @param ancestryid Database column ancestryID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param ancestryname Database column ancestryName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param bloodlineid Database column bloodlineID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param perception Database column perception SqlType(TINYINT UNSIGNED), Default(None)
   *  @param willpower Database column willpower SqlType(TINYINT UNSIGNED), Default(None)
   *  @param charisma Database column charisma SqlType(TINYINT UNSIGNED), Default(None)
   *  @param memory Database column memory SqlType(TINYINT UNSIGNED), Default(None)
   *  @param intelligence Database column intelligence SqlType(TINYINT UNSIGNED), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None)
   *  @param shortdescription Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None) */
  case class ChrancestriesRow(ancestryid: Byte, ancestryname: Option[String] = None, bloodlineid: Option[Byte] = None, description: Option[String] = None, perception: Option[Byte] = None, willpower: Option[Byte] = None, charisma: Option[Byte] = None, memory: Option[Byte] = None, intelligence: Option[Byte] = None, iconid: Option[Int] = None, shortdescription: Option[String] = None)
  /** GetResult implicit for fetching ChrancestriesRow objects using plain SQL queries */
  implicit def GetResultChrancestriesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Byte]], e3: GR[Option[Int]]): GR[ChrancestriesRow] = GR{
    prs => import prs._
    ChrancestriesRow.tupled((<<[Byte], <<?[String], <<?[Byte], <<?[String], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Int], <<?[String]))
  }
  /** Table description of table chrAncestries. Objects of this class serve as prototypes for rows in queries. */
  class Chrancestries(_tableTag: Tag) extends Table[ChrancestriesRow](_tableTag, "chrAncestries") {
    def * = (ancestryid, ancestryname, bloodlineid, description, perception, willpower, charisma, memory, intelligence, iconid, shortdescription) <> (ChrancestriesRow.tupled, ChrancestriesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(ancestryid), ancestryname, bloodlineid, description, perception, willpower, charisma, memory, intelligence, iconid, shortdescription).shaped.<>({r=>import r._; _1.map(_=> ChrancestriesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ancestryID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val ancestryid: Rep[Byte] = column[Byte]("ancestryID", O.PrimaryKey)
    /** Database column ancestryName SqlType(VARCHAR), Length(100,true), Default(None) */
    val ancestryname: Rep[Option[String]] = column[Option[String]]("ancestryName", O.Length(100,varying=true), O.Default(None))
    /** Database column bloodlineID SqlType(TINYINT UNSIGNED), Default(None) */
    val bloodlineid: Rep[Option[Byte]] = column[Option[Byte]]("bloodlineID", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column perception SqlType(TINYINT UNSIGNED), Default(None) */
    val perception: Rep[Option[Byte]] = column[Option[Byte]]("perception", O.Default(None))
    /** Database column willpower SqlType(TINYINT UNSIGNED), Default(None) */
    val willpower: Rep[Option[Byte]] = column[Option[Byte]]("willpower", O.Default(None))
    /** Database column charisma SqlType(TINYINT UNSIGNED), Default(None) */
    val charisma: Rep[Option[Byte]] = column[Option[Byte]]("charisma", O.Default(None))
    /** Database column memory SqlType(TINYINT UNSIGNED), Default(None) */
    val memory: Rep[Option[Byte]] = column[Option[Byte]]("memory", O.Default(None))
    /** Database column intelligence SqlType(TINYINT UNSIGNED), Default(None) */
    val intelligence: Rep[Option[Byte]] = column[Option[Byte]]("intelligence", O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
    /** Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None) */
    val shortdescription: Rep[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Chrancestries */
  lazy val Chrancestries = new TableQuery(tag => new Chrancestries(tag))

  /** Entity class storing rows of table Chrattributes
   *  @param attributeid Database column attributeID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param attributename Database column attributeName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None)
   *  @param shortdescription Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param notes Database column notes SqlType(VARCHAR), Length(500,true), Default(None) */
  case class ChrattributesRow(attributeid: Byte, attributename: Option[String] = None, description: Option[String] = None, iconid: Option[Int] = None, shortdescription: Option[String] = None, notes: Option[String] = None)
  /** GetResult implicit for fetching ChrattributesRow objects using plain SQL queries */
  implicit def GetResultChrattributesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ChrattributesRow] = GR{
    prs => import prs._
    ChrattributesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table chrAttributes. Objects of this class serve as prototypes for rows in queries. */
  class Chrattributes(_tableTag: Tag) extends Table[ChrattributesRow](_tableTag, "chrAttributes") {
    def * = (attributeid, attributename, description, iconid, shortdescription, notes) <> (ChrattributesRow.tupled, ChrattributesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(attributeid), attributename, description, iconid, shortdescription, notes).shaped.<>({r=>import r._; _1.map(_=> ChrattributesRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column attributeID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val attributeid: Rep[Byte] = column[Byte]("attributeID", O.PrimaryKey)
    /** Database column attributeName SqlType(VARCHAR), Length(100,true), Default(None) */
    val attributename: Rep[Option[String]] = column[Option[String]]("attributeName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
    /** Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None) */
    val shortdescription: Rep[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true), O.Default(None))
    /** Database column notes SqlType(VARCHAR), Length(500,true), Default(None) */
    val notes: Rep[Option[String]] = column[Option[String]]("notes", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Chrattributes */
  lazy val Chrattributes = new TableQuery(tag => new Chrattributes(tag))

  /** Entity class storing rows of table Chrbloodlines
   *  @param bloodlineid Database column bloodlineID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param bloodlinename Database column bloodlineName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param raceid Database column raceID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param maledescription Database column maleDescription SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param femaledescription Database column femaleDescription SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param shiptypeid Database column shipTypeID SqlType(INT), Default(None)
   *  @param corporationid Database column corporationID SqlType(INT), Default(None)
   *  @param perception Database column perception SqlType(TINYINT UNSIGNED), Default(None)
   *  @param willpower Database column willpower SqlType(TINYINT UNSIGNED), Default(None)
   *  @param charisma Database column charisma SqlType(TINYINT UNSIGNED), Default(None)
   *  @param memory Database column memory SqlType(TINYINT UNSIGNED), Default(None)
   *  @param intelligence Database column intelligence SqlType(TINYINT UNSIGNED), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None)
   *  @param shortdescription Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param shortmaledescription Database column shortMaleDescription SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param shortfemaledescription Database column shortFemaleDescription SqlType(VARCHAR), Length(500,true), Default(None) */
  case class ChrbloodlinesRow(bloodlineid: Byte, bloodlinename: Option[String] = None, raceid: Option[Byte] = None, description: Option[String] = None, maledescription: Option[String] = None, femaledescription: Option[String] = None, shiptypeid: Option[Int] = None, corporationid: Option[Int] = None, perception: Option[Byte] = None, willpower: Option[Byte] = None, charisma: Option[Byte] = None, memory: Option[Byte] = None, intelligence: Option[Byte] = None, iconid: Option[Int] = None, shortdescription: Option[String] = None, shortmaledescription: Option[String] = None, shortfemaledescription: Option[String] = None)
  /** GetResult implicit for fetching ChrbloodlinesRow objects using plain SQL queries */
  implicit def GetResultChrbloodlinesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Byte]], e3: GR[Option[Int]]): GR[ChrbloodlinesRow] = GR{
    prs => import prs._
    ChrbloodlinesRow.tupled((<<[Byte], <<?[String], <<?[Byte], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Int], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table chrBloodlines. Objects of this class serve as prototypes for rows in queries. */
  class Chrbloodlines(_tableTag: Tag) extends Table[ChrbloodlinesRow](_tableTag, "chrBloodlines") {
    def * = (bloodlineid, bloodlinename, raceid, description, maledescription, femaledescription, shiptypeid, corporationid, perception, willpower, charisma, memory, intelligence, iconid, shortdescription, shortmaledescription, shortfemaledescription) <> (ChrbloodlinesRow.tupled, ChrbloodlinesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(bloodlineid), bloodlinename, raceid, description, maledescription, femaledescription, shiptypeid, corporationid, perception, willpower, charisma, memory, intelligence, iconid, shortdescription, shortmaledescription, shortfemaledescription).shaped.<>({r=>import r._; _1.map(_=> ChrbloodlinesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column bloodlineID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val bloodlineid: Rep[Byte] = column[Byte]("bloodlineID", O.PrimaryKey)
    /** Database column bloodlineName SqlType(VARCHAR), Length(100,true), Default(None) */
    val bloodlinename: Rep[Option[String]] = column[Option[String]]("bloodlineName", O.Length(100,varying=true), O.Default(None))
    /** Database column raceID SqlType(TINYINT UNSIGNED), Default(None) */
    val raceid: Rep[Option[Byte]] = column[Option[Byte]]("raceID", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column maleDescription SqlType(VARCHAR), Length(1000,true), Default(None) */
    val maledescription: Rep[Option[String]] = column[Option[String]]("maleDescription", O.Length(1000,varying=true), O.Default(None))
    /** Database column femaleDescription SqlType(VARCHAR), Length(1000,true), Default(None) */
    val femaledescription: Rep[Option[String]] = column[Option[String]]("femaleDescription", O.Length(1000,varying=true), O.Default(None))
    /** Database column shipTypeID SqlType(INT), Default(None) */
    val shiptypeid: Rep[Option[Int]] = column[Option[Int]]("shipTypeID", O.Default(None))
    /** Database column corporationID SqlType(INT), Default(None) */
    val corporationid: Rep[Option[Int]] = column[Option[Int]]("corporationID", O.Default(None))
    /** Database column perception SqlType(TINYINT UNSIGNED), Default(None) */
    val perception: Rep[Option[Byte]] = column[Option[Byte]]("perception", O.Default(None))
    /** Database column willpower SqlType(TINYINT UNSIGNED), Default(None) */
    val willpower: Rep[Option[Byte]] = column[Option[Byte]]("willpower", O.Default(None))
    /** Database column charisma SqlType(TINYINT UNSIGNED), Default(None) */
    val charisma: Rep[Option[Byte]] = column[Option[Byte]]("charisma", O.Default(None))
    /** Database column memory SqlType(TINYINT UNSIGNED), Default(None) */
    val memory: Rep[Option[Byte]] = column[Option[Byte]]("memory", O.Default(None))
    /** Database column intelligence SqlType(TINYINT UNSIGNED), Default(None) */
    val intelligence: Rep[Option[Byte]] = column[Option[Byte]]("intelligence", O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
    /** Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None) */
    val shortdescription: Rep[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true), O.Default(None))
    /** Database column shortMaleDescription SqlType(VARCHAR), Length(500,true), Default(None) */
    val shortmaledescription: Rep[Option[String]] = column[Option[String]]("shortMaleDescription", O.Length(500,varying=true), O.Default(None))
    /** Database column shortFemaleDescription SqlType(VARCHAR), Length(500,true), Default(None) */
    val shortfemaledescription: Rep[Option[String]] = column[Option[String]]("shortFemaleDescription", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Chrbloodlines */
  lazy val Chrbloodlines = new TableQuery(tag => new Chrbloodlines(tag))

  /** Entity class storing rows of table Chrfactions
   *  @param factionid Database column factionID SqlType(INT), PrimaryKey
   *  @param factionname Database column factionName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param raceids Database column raceIDs SqlType(INT), Default(None)
   *  @param solarsystemid Database column solarSystemID SqlType(INT), Default(None)
   *  @param corporationid Database column corporationID SqlType(INT), Default(None)
   *  @param sizefactor Database column sizeFactor SqlType(DOUBLE), Default(None)
   *  @param stationcount Database column stationCount SqlType(SMALLINT), Default(None)
   *  @param stationsystemcount Database column stationSystemCount SqlType(SMALLINT), Default(None)
   *  @param militiacorporationid Database column militiaCorporationID SqlType(INT), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None) */
  case class ChrfactionsRow(factionid: Int, factionname: Option[String] = None, description: Option[String] = None, raceids: Option[Int] = None, solarsystemid: Option[Int] = None, corporationid: Option[Int] = None, sizefactor: Option[Double] = None, stationcount: Option[Short] = None, stationsystemcount: Option[Short] = None, militiacorporationid: Option[Int] = None, iconid: Option[Int] = None)
  /** GetResult implicit for fetching ChrfactionsRow objects using plain SQL queries */
  implicit def GetResultChrfactionsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Double]], e4: GR[Option[Short]]): GR[ChrfactionsRow] = GR{
    prs => import prs._
    ChrfactionsRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Double], <<?[Short], <<?[Short], <<?[Int], <<?[Int]))
  }
  /** Table description of table chrFactions. Objects of this class serve as prototypes for rows in queries. */
  class Chrfactions(_tableTag: Tag) extends Table[ChrfactionsRow](_tableTag, "chrFactions") {
    def * = (factionid, factionname, description, raceids, solarsystemid, corporationid, sizefactor, stationcount, stationsystemcount, militiacorporationid, iconid) <> (ChrfactionsRow.tupled, ChrfactionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(factionid), factionname, description, raceids, solarsystemid, corporationid, sizefactor, stationcount, stationsystemcount, militiacorporationid, iconid).shaped.<>({r=>import r._; _1.map(_=> ChrfactionsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column factionID SqlType(INT), PrimaryKey */
    val factionid: Rep[Int] = column[Int]("factionID", O.PrimaryKey)
    /** Database column factionName SqlType(VARCHAR), Length(100,true), Default(None) */
    val factionname: Rep[Option[String]] = column[Option[String]]("factionName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column raceIDs SqlType(INT), Default(None) */
    val raceids: Rep[Option[Int]] = column[Option[Int]]("raceIDs", O.Default(None))
    /** Database column solarSystemID SqlType(INT), Default(None) */
    val solarsystemid: Rep[Option[Int]] = column[Option[Int]]("solarSystemID", O.Default(None))
    /** Database column corporationID SqlType(INT), Default(None) */
    val corporationid: Rep[Option[Int]] = column[Option[Int]]("corporationID", O.Default(None))
    /** Database column sizeFactor SqlType(DOUBLE), Default(None) */
    val sizefactor: Rep[Option[Double]] = column[Option[Double]]("sizeFactor", O.Default(None))
    /** Database column stationCount SqlType(SMALLINT), Default(None) */
    val stationcount: Rep[Option[Short]] = column[Option[Short]]("stationCount", O.Default(None))
    /** Database column stationSystemCount SqlType(SMALLINT), Default(None) */
    val stationsystemcount: Rep[Option[Short]] = column[Option[Short]]("stationSystemCount", O.Default(None))
    /** Database column militiaCorporationID SqlType(INT), Default(None) */
    val militiacorporationid: Rep[Option[Int]] = column[Option[Int]]("militiaCorporationID", O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Chrfactions */
  lazy val Chrfactions = new TableQuery(tag => new Chrfactions(tag))

  /** Entity class storing rows of table Chrraces
   *  @param raceid Database column raceID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param racename Database column raceName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None)
   *  @param shortdescription Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None) */
  case class ChrracesRow(raceid: Byte, racename: Option[String] = None, description: Option[String] = None, iconid: Option[Int] = None, shortdescription: Option[String] = None)
  /** GetResult implicit for fetching ChrracesRow objects using plain SQL queries */
  implicit def GetResultChrracesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ChrracesRow] = GR{
    prs => import prs._
    ChrracesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table chrRaces. Objects of this class serve as prototypes for rows in queries. */
  class Chrraces(_tableTag: Tag) extends Table[ChrracesRow](_tableTag, "chrRaces") {
    def * = (raceid, racename, description, iconid, shortdescription) <> (ChrracesRow.tupled, ChrracesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(raceid), racename, description, iconid, shortdescription).shaped.<>({r=>import r._; _1.map(_=> ChrracesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column raceID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val raceid: Rep[Byte] = column[Byte]("raceID", O.PrimaryKey)
    /** Database column raceName SqlType(VARCHAR), Length(100,true), Default(None) */
    val racename: Rep[Option[String]] = column[Option[String]]("raceName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
    /** Database column shortDescription SqlType(VARCHAR), Length(500,true), Default(None) */
    val shortdescription: Rep[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Chrraces */
  lazy val Chrraces = new TableQuery(tag => new Chrraces(tag))

  /** Entity class storing rows of table Crpactivities
   *  @param activityid Database column activityID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param activityname Database column activityName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
  case class CrpactivitiesRow(activityid: Byte, activityname: Option[String] = None, description: Option[String] = None)
  /** GetResult implicit for fetching CrpactivitiesRow objects using plain SQL queries */
  implicit def GetResultCrpactivitiesRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[CrpactivitiesRow] = GR{
    prs => import prs._
    CrpactivitiesRow.tupled((<<[Byte], <<?[String], <<?[String]))
  }
  /** Table description of table crpActivities. Objects of this class serve as prototypes for rows in queries. */
  class Crpactivities(_tableTag: Tag) extends Table[CrpactivitiesRow](_tableTag, "crpActivities") {
    def * = (activityid, activityname, description) <> (CrpactivitiesRow.tupled, CrpactivitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(activityid), activityname, description).shaped.<>({r=>import r._; _1.map(_=> CrpactivitiesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column activityID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val activityid: Rep[Byte] = column[Byte]("activityID", O.PrimaryKey)
    /** Database column activityName SqlType(VARCHAR), Length(100,true), Default(None) */
    val activityname: Rep[Option[String]] = column[Option[String]]("activityName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Crpactivities */
  lazy val Crpactivities = new TableQuery(tag => new Crpactivities(tag))

  /** Entity class storing rows of table Crpnpccorporationdivisions
   *  @param corporationid Database column corporationID SqlType(INT)
   *  @param divisionid Database column divisionID SqlType(TINYINT UNSIGNED)
   *  @param size Database column size SqlType(TINYINT UNSIGNED), Default(None) */
  case class CrpnpccorporationdivisionsRow(corporationid: Int, divisionid: Byte, size: Option[Byte] = None)
  /** GetResult implicit for fetching CrpnpccorporationdivisionsRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationdivisionsRow(implicit e0: GR[Int], e1: GR[Byte], e2: GR[Option[Byte]]): GR[CrpnpccorporationdivisionsRow] = GR{
    prs => import prs._
    CrpnpccorporationdivisionsRow.tupled((<<[Int], <<[Byte], <<?[Byte]))
  }
  /** Table description of table crpNPCCorporationDivisions. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporationdivisions(_tableTag: Tag) extends Table[CrpnpccorporationdivisionsRow](_tableTag, "crpNPCCorporationDivisions") {
    def * = (corporationid, divisionid, size) <> (CrpnpccorporationdivisionsRow.tupled, CrpnpccorporationdivisionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(corporationid), Rep.Some(divisionid), size).shaped.<>({r=>import r._; _1.map(_=> CrpnpccorporationdivisionsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column corporationID SqlType(INT) */
    val corporationid: Rep[Int] = column[Int]("corporationID")
    /** Database column divisionID SqlType(TINYINT UNSIGNED) */
    val divisionid: Rep[Byte] = column[Byte]("divisionID")
    /** Database column size SqlType(TINYINT UNSIGNED), Default(None) */
    val size: Rep[Option[Byte]] = column[Option[Byte]]("size", O.Default(None))

    /** Primary key of Crpnpccorporationdivisions (database name crpNPCCorporationDivisions_PK) */
    val pk = primaryKey("crpNPCCorporationDivisions_PK", (corporationid, divisionid))
  }
  /** Collection-like TableQuery object for table Crpnpccorporationdivisions */
  lazy val Crpnpccorporationdivisions = new TableQuery(tag => new Crpnpccorporationdivisions(tag))

  /** Entity class storing rows of table Crpnpccorporationresearchfields
   *  @param skillid Database column skillID SqlType(INT)
   *  @param corporationid Database column corporationID SqlType(INT) */
  case class CrpnpccorporationresearchfieldsRow(skillid: Int, corporationid: Int)
  /** GetResult implicit for fetching CrpnpccorporationresearchfieldsRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationresearchfieldsRow(implicit e0: GR[Int]): GR[CrpnpccorporationresearchfieldsRow] = GR{
    prs => import prs._
    CrpnpccorporationresearchfieldsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table crpNPCCorporationResearchFields. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporationresearchfields(_tableTag: Tag) extends Table[CrpnpccorporationresearchfieldsRow](_tableTag, "crpNPCCorporationResearchFields") {
    def * = (skillid, corporationid) <> (CrpnpccorporationresearchfieldsRow.tupled, CrpnpccorporationresearchfieldsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(skillid), Rep.Some(corporationid)).shaped.<>({r=>import r._; _1.map(_=> CrpnpccorporationresearchfieldsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column skillID SqlType(INT) */
    val skillid: Rep[Int] = column[Int]("skillID")
    /** Database column corporationID SqlType(INT) */
    val corporationid: Rep[Int] = column[Int]("corporationID")

    /** Primary key of Crpnpccorporationresearchfields (database name crpNPCCorporationResearchFields_PK) */
    val pk = primaryKey("crpNPCCorporationResearchFields_PK", (skillid, corporationid))
  }
  /** Collection-like TableQuery object for table Crpnpccorporationresearchfields */
  lazy val Crpnpccorporationresearchfields = new TableQuery(tag => new Crpnpccorporationresearchfields(tag))

  /** Row type of table Crpnpccorporations */
  type CrpnpccorporationsRow = HCons[Int,HCons[Option[Char],HCons[Option[Char],HCons[Option[Int],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Int],HCons[Option[Long],HCons[Option[Int],HCons[Option[Double],HCons[Option[Boolean],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Double],HCons[Option[Short],HCons[Option[Short],HCons[Option[String],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for CrpnpccorporationsRow providing default values if available in the database schema. */
  def CrpnpccorporationsRow(corporationid: Int, size: Option[Char] = None, extent: Option[Char] = None, solarsystemid: Option[Int] = None, investorid1: Option[Int] = None, investorshares1: Option[Byte] = None, investorid2: Option[Int] = None, investorshares2: Option[Byte] = None, investorid3: Option[Int] = None, investorshares3: Option[Byte] = None, investorid4: Option[Int] = None, investorshares4: Option[Byte] = None, friendid: Option[Int] = None, enemyid: Option[Int] = None, publicshares: Option[Long] = None, initialprice: Option[Int] = None, minsecurity: Option[Double] = None, scattered: Option[Boolean] = None, fringe: Option[Byte] = None, corridor: Option[Byte] = None, hub: Option[Byte] = None, border: Option[Byte] = None, factionid: Option[Int] = None, sizefactor: Option[Double] = None, stationcount: Option[Short] = None, stationsystemcount: Option[Short] = None, description: Option[String] = None, iconid: Option[Int] = None): CrpnpccorporationsRow = {
    corporationid :: size :: extent :: solarsystemid :: investorid1 :: investorshares1 :: investorid2 :: investorshares2 :: investorid3 :: investorshares3 :: investorid4 :: investorshares4 :: friendid :: enemyid :: publicshares :: initialprice :: minsecurity :: scattered :: fringe :: corridor :: hub :: border :: factionid :: sizefactor :: stationcount :: stationsystemcount :: description :: iconid :: HNil
  }
  /** GetResult implicit for fetching CrpnpccorporationsRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationsRow(implicit e0: GR[Int], e1: GR[Option[Char]], e2: GR[Option[Int]], e3: GR[Option[Byte]], e4: GR[Option[Long]], e5: GR[Option[Double]], e6: GR[Option[Boolean]], e7: GR[Option[Short]], e8: GR[Option[String]]): GR[CrpnpccorporationsRow] = GR{
    prs => import prs._
    <<[Int] :: <<?[Char] :: <<?[Char] :: <<?[Int] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Int] :: <<?[Long] :: <<?[Int] :: <<?[Double] :: <<?[Boolean] :: <<?[Byte] :: <<?[Byte] :: <<?[Byte] :: <<?[Byte] :: <<?[Int] :: <<?[Double] :: <<?[Short] :: <<?[Short] :: <<?[String] :: <<?[Int] :: HNil
  }
  /** Table description of table crpNPCCorporations. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporations(_tableTag: Tag) extends Table[CrpnpccorporationsRow](_tableTag, "crpNPCCorporations") {
    def * = corporationid :: size :: extent :: solarsystemid :: investorid1 :: investorshares1 :: investorid2 :: investorshares2 :: investorid3 :: investorshares3 :: investorid4 :: investorshares4 :: friendid :: enemyid :: publicshares :: initialprice :: minsecurity :: scattered :: fringe :: corridor :: hub :: border :: factionid :: sizefactor :: stationcount :: stationsystemcount :: description :: iconid :: HNil

    /** Database column corporationID SqlType(INT), PrimaryKey */
    val corporationid: Rep[Int] = column[Int]("corporationID", O.PrimaryKey)
    /** Database column size SqlType(CHAR), Default(None) */
    val size: Rep[Option[Char]] = column[Option[Char]]("size", O.Default(None))
    /** Database column extent SqlType(CHAR), Default(None) */
    val extent: Rep[Option[Char]] = column[Option[Char]]("extent", O.Default(None))
    /** Database column solarSystemID SqlType(INT), Default(None) */
    val solarsystemid: Rep[Option[Int]] = column[Option[Int]]("solarSystemID", O.Default(None))
    /** Database column investorID1 SqlType(INT), Default(None) */
    val investorid1: Rep[Option[Int]] = column[Option[Int]]("investorID1", O.Default(None))
    /** Database column investorShares1 SqlType(TINYINT UNSIGNED), Default(None) */
    val investorshares1: Rep[Option[Byte]] = column[Option[Byte]]("investorShares1", O.Default(None))
    /** Database column investorID2 SqlType(INT), Default(None) */
    val investorid2: Rep[Option[Int]] = column[Option[Int]]("investorID2", O.Default(None))
    /** Database column investorShares2 SqlType(TINYINT UNSIGNED), Default(None) */
    val investorshares2: Rep[Option[Byte]] = column[Option[Byte]]("investorShares2", O.Default(None))
    /** Database column investorID3 SqlType(INT), Default(None) */
    val investorid3: Rep[Option[Int]] = column[Option[Int]]("investorID3", O.Default(None))
    /** Database column investorShares3 SqlType(TINYINT UNSIGNED), Default(None) */
    val investorshares3: Rep[Option[Byte]] = column[Option[Byte]]("investorShares3", O.Default(None))
    /** Database column investorID4 SqlType(INT), Default(None) */
    val investorid4: Rep[Option[Int]] = column[Option[Int]]("investorID4", O.Default(None))
    /** Database column investorShares4 SqlType(TINYINT UNSIGNED), Default(None) */
    val investorshares4: Rep[Option[Byte]] = column[Option[Byte]]("investorShares4", O.Default(None))
    /** Database column friendID SqlType(INT), Default(None) */
    val friendid: Rep[Option[Int]] = column[Option[Int]]("friendID", O.Default(None))
    /** Database column enemyID SqlType(INT), Default(None) */
    val enemyid: Rep[Option[Int]] = column[Option[Int]]("enemyID", O.Default(None))
    /** Database column publicShares SqlType(BIGINT), Default(None) */
    val publicshares: Rep[Option[Long]] = column[Option[Long]]("publicShares", O.Default(None))
    /** Database column initialPrice SqlType(INT), Default(None) */
    val initialprice: Rep[Option[Int]] = column[Option[Int]]("initialPrice", O.Default(None))
    /** Database column minSecurity SqlType(DOUBLE), Default(None) */
    val minsecurity: Rep[Option[Double]] = column[Option[Double]]("minSecurity", O.Default(None))
    /** Database column scattered SqlType(BIT), Default(None) */
    val scattered: Rep[Option[Boolean]] = column[Option[Boolean]]("scattered", O.Default(None))
    /** Database column fringe SqlType(TINYINT UNSIGNED), Default(None) */
    val fringe: Rep[Option[Byte]] = column[Option[Byte]]("fringe", O.Default(None))
    /** Database column corridor SqlType(TINYINT UNSIGNED), Default(None) */
    val corridor: Rep[Option[Byte]] = column[Option[Byte]]("corridor", O.Default(None))
    /** Database column hub SqlType(TINYINT UNSIGNED), Default(None) */
    val hub: Rep[Option[Byte]] = column[Option[Byte]]("hub", O.Default(None))
    /** Database column border SqlType(TINYINT UNSIGNED), Default(None) */
    val border: Rep[Option[Byte]] = column[Option[Byte]]("border", O.Default(None))
    /** Database column factionID SqlType(INT), Default(None) */
    val factionid: Rep[Option[Int]] = column[Option[Int]]("factionID", O.Default(None))
    /** Database column sizeFactor SqlType(DOUBLE), Default(None) */
    val sizefactor: Rep[Option[Double]] = column[Option[Double]]("sizeFactor", O.Default(None))
    /** Database column stationCount SqlType(SMALLINT), Default(None) */
    val stationcount: Rep[Option[Short]] = column[Option[Short]]("stationCount", O.Default(None))
    /** Database column stationSystemCount SqlType(SMALLINT), Default(None) */
    val stationsystemcount: Rep[Option[Short]] = column[Option[Short]]("stationSystemCount", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(4000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(4000,varying=true), O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Crpnpccorporations */
  lazy val Crpnpccorporations = new TableQuery(tag => new Crpnpccorporations(tag))

  /** Entity class storing rows of table Crpnpccorporationtrades
   *  @param corporationid Database column corporationID SqlType(INT)
   *  @param typeid Database column typeID SqlType(INT) */
  case class CrpnpccorporationtradesRow(corporationid: Int, typeid: Int)
  /** GetResult implicit for fetching CrpnpccorporationtradesRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationtradesRow(implicit e0: GR[Int]): GR[CrpnpccorporationtradesRow] = GR{
    prs => import prs._
    CrpnpccorporationtradesRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table crpNPCCorporationTrades. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporationtrades(_tableTag: Tag) extends Table[CrpnpccorporationtradesRow](_tableTag, "crpNPCCorporationTrades") {
    def * = (corporationid, typeid) <> (CrpnpccorporationtradesRow.tupled, CrpnpccorporationtradesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(corporationid), Rep.Some(typeid)).shaped.<>({r=>import r._; _1.map(_=> CrpnpccorporationtradesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column corporationID SqlType(INT) */
    val corporationid: Rep[Int] = column[Int]("corporationID")
    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")

    /** Primary key of Crpnpccorporationtrades (database name crpNPCCorporationTrades_PK) */
    val pk = primaryKey("crpNPCCorporationTrades_PK", (corporationid, typeid))
  }
  /** Collection-like TableQuery object for table Crpnpccorporationtrades */
  lazy val Crpnpccorporationtrades = new TableQuery(tag => new Crpnpccorporationtrades(tag))

  /** Entity class storing rows of table Crpnpcdivisions
   *  @param divisionid Database column divisionID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param divisionname Database column divisionName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param leadertype Database column leaderType SqlType(VARCHAR), Length(100,true), Default(None) */
  case class CrpnpcdivisionsRow(divisionid: Byte, divisionname: Option[String] = None, description: Option[String] = None, leadertype: Option[String] = None)
  /** GetResult implicit for fetching CrpnpcdivisionsRow objects using plain SQL queries */
  implicit def GetResultCrpnpcdivisionsRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[CrpnpcdivisionsRow] = GR{
    prs => import prs._
    CrpnpcdivisionsRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table crpNPCDivisions. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpcdivisions(_tableTag: Tag) extends Table[CrpnpcdivisionsRow](_tableTag, "crpNPCDivisions") {
    def * = (divisionid, divisionname, description, leadertype) <> (CrpnpcdivisionsRow.tupled, CrpnpcdivisionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(divisionid), divisionname, description, leadertype).shaped.<>({r=>import r._; _1.map(_=> CrpnpcdivisionsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column divisionID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val divisionid: Rep[Byte] = column[Byte]("divisionID", O.PrimaryKey)
    /** Database column divisionName SqlType(VARCHAR), Length(100,true), Default(None) */
    val divisionname: Rep[Option[String]] = column[Option[String]]("divisionName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column leaderType SqlType(VARCHAR), Length(100,true), Default(None) */
    val leadertype: Rep[Option[String]] = column[Option[String]]("leaderType", O.Length(100,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Crpnpcdivisions */
  lazy val Crpnpcdivisions = new TableQuery(tag => new Crpnpcdivisions(tag))

  /** Entity class storing rows of table Dgmattributecategories
   *  @param categoryid Database column categoryID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param categoryname Database column categoryName SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param categorydescription Database column categoryDescription SqlType(VARCHAR), Length(200,true), Default(None) */
  case class DgmattributecategoriesRow(categoryid: Byte, categoryname: Option[String] = None, categorydescription: Option[String] = None)
  /** GetResult implicit for fetching DgmattributecategoriesRow objects using plain SQL queries */
  implicit def GetResultDgmattributecategoriesRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[DgmattributecategoriesRow] = GR{
    prs => import prs._
    DgmattributecategoriesRow.tupled((<<[Byte], <<?[String], <<?[String]))
  }
  /** Table description of table dgmAttributeCategories. Objects of this class serve as prototypes for rows in queries. */
  class Dgmattributecategories(_tableTag: Tag) extends Table[DgmattributecategoriesRow](_tableTag, "dgmAttributeCategories") {
    def * = (categoryid, categoryname, categorydescription) <> (DgmattributecategoriesRow.tupled, DgmattributecategoriesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(categoryid), categoryname, categorydescription).shaped.<>({r=>import r._; _1.map(_=> DgmattributecategoriesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column categoryID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val categoryid: Rep[Byte] = column[Byte]("categoryID", O.PrimaryKey)
    /** Database column categoryName SqlType(VARCHAR), Length(50,true), Default(None) */
    val categoryname: Rep[Option[String]] = column[Option[String]]("categoryName", O.Length(50,varying=true), O.Default(None))
    /** Database column categoryDescription SqlType(VARCHAR), Length(200,true), Default(None) */
    val categorydescription: Rep[Option[String]] = column[Option[String]]("categoryDescription", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Dgmattributecategories */
  lazy val Dgmattributecategories = new TableQuery(tag => new Dgmattributecategories(tag))

  /** Entity class storing rows of table Dgmattributetypes
   *  @param attributeid Database column attributeID SqlType(SMALLINT), PrimaryKey
   *  @param attributename Database column attributeName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None)
   *  @param defaultvalue Database column defaultValue SqlType(DOUBLE), Default(None)
   *  @param published Database column published SqlType(BIT), Default(None)
   *  @param displayname Database column displayName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param unitid Database column unitID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param stackable Database column stackable SqlType(BIT), Default(None)
   *  @param highisgood Database column highIsGood SqlType(BIT), Default(None)
   *  @param categoryid Database column categoryID SqlType(TINYINT UNSIGNED), Default(None) */
  case class DgmattributetypesRow(attributeid: Short, attributename: Option[String] = None, description: Option[String] = None, iconid: Option[Int] = None, defaultvalue: Option[Double] = None, published: Option[Boolean] = None, displayname: Option[String] = None, unitid: Option[Byte] = None, stackable: Option[Boolean] = None, highisgood: Option[Boolean] = None, categoryid: Option[Byte] = None)
  /** GetResult implicit for fetching DgmattributetypesRow objects using plain SQL queries */
  implicit def GetResultDgmattributetypesRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Double]], e4: GR[Option[Boolean]], e5: GR[Option[Byte]]): GR[DgmattributetypesRow] = GR{
    prs => import prs._
    DgmattributetypesRow.tupled((<<[Short], <<?[String], <<?[String], <<?[Int], <<?[Double], <<?[Boolean], <<?[String], <<?[Byte], <<?[Boolean], <<?[Boolean], <<?[Byte]))
  }
  /** Table description of table dgmAttributeTypes. Objects of this class serve as prototypes for rows in queries. */
  class Dgmattributetypes(_tableTag: Tag) extends Table[DgmattributetypesRow](_tableTag, "dgmAttributeTypes") {
    def * = (attributeid, attributename, description, iconid, defaultvalue, published, displayname, unitid, stackable, highisgood, categoryid) <> (DgmattributetypesRow.tupled, DgmattributetypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(attributeid), attributename, description, iconid, defaultvalue, published, displayname, unitid, stackable, highisgood, categoryid).shaped.<>({r=>import r._; _1.map(_=> DgmattributetypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column attributeID SqlType(SMALLINT), PrimaryKey */
    val attributeid: Rep[Short] = column[Short]("attributeID", O.PrimaryKey)
    /** Database column attributeName SqlType(VARCHAR), Length(100,true), Default(None) */
    val attributename: Rep[Option[String]] = column[Option[String]]("attributeName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
    /** Database column defaultValue SqlType(DOUBLE), Default(None) */
    val defaultvalue: Rep[Option[Double]] = column[Option[Double]]("defaultValue", O.Default(None))
    /** Database column published SqlType(BIT), Default(None) */
    val published: Rep[Option[Boolean]] = column[Option[Boolean]]("published", O.Default(None))
    /** Database column displayName SqlType(VARCHAR), Length(100,true), Default(None) */
    val displayname: Rep[Option[String]] = column[Option[String]]("displayName", O.Length(100,varying=true), O.Default(None))
    /** Database column unitID SqlType(TINYINT UNSIGNED), Default(None) */
    val unitid: Rep[Option[Byte]] = column[Option[Byte]]("unitID", O.Default(None))
    /** Database column stackable SqlType(BIT), Default(None) */
    val stackable: Rep[Option[Boolean]] = column[Option[Boolean]]("stackable", O.Default(None))
    /** Database column highIsGood SqlType(BIT), Default(None) */
    val highisgood: Rep[Option[Boolean]] = column[Option[Boolean]]("highIsGood", O.Default(None))
    /** Database column categoryID SqlType(TINYINT UNSIGNED), Default(None) */
    val categoryid: Rep[Option[Byte]] = column[Option[Byte]]("categoryID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Dgmattributetypes */
  lazy val Dgmattributetypes = new TableQuery(tag => new Dgmattributetypes(tag))

  /** Row type of table Dgmeffects */
  type DgmeffectsRow = HCons[Short,HCons[Option[String],HCons[Option[Short],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Byte],HCons[Option[String],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for DgmeffectsRow providing default values if available in the database schema. */
  def DgmeffectsRow(effectid: Short, effectname: Option[String] = None, effectcategory: Option[Short] = None, preexpression: Option[Int] = None, postexpression: Option[Int] = None, description: Option[String] = None, guid: Option[String] = None, iconid: Option[Int] = None, isoffensive: Option[Boolean] = None, isassistance: Option[Boolean] = None, durationattributeid: Option[Short] = None, trackingspeedattributeid: Option[Short] = None, dischargeattributeid: Option[Short] = None, rangeattributeid: Option[Short] = None, falloffattributeid: Option[Short] = None, disallowautorepeat: Option[Boolean] = None, published: Option[Boolean] = None, displayname: Option[String] = None, iswarpsafe: Option[Boolean] = None, rangechance: Option[Boolean] = None, electronicchance: Option[Boolean] = None, propulsionchance: Option[Boolean] = None, distribution: Option[Byte] = None, sfxname: Option[String] = None, npcusagechanceattributeid: Option[Short] = None, npcactivationchanceattributeid: Option[Short] = None, fittingusagechanceattributeid: Option[Short] = None, modifierinfo: Option[String] = None): DgmeffectsRow = {
    effectid :: effectname :: effectcategory :: preexpression :: postexpression :: description :: guid :: iconid :: isoffensive :: isassistance :: durationattributeid :: trackingspeedattributeid :: dischargeattributeid :: rangeattributeid :: falloffattributeid :: disallowautorepeat :: published :: displayname :: iswarpsafe :: rangechance :: electronicchance :: propulsionchance :: distribution :: sfxname :: npcusagechanceattributeid :: npcactivationchanceattributeid :: fittingusagechanceattributeid :: modifierinfo :: HNil
  }
  /** GetResult implicit for fetching DgmeffectsRow objects using plain SQL queries */
  implicit def GetResultDgmeffectsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Short]], e3: GR[Option[Int]], e4: GR[Option[Boolean]], e5: GR[Option[Byte]]): GR[DgmeffectsRow] = GR{
    prs => import prs._
    <<[Short] :: <<?[String] :: <<?[Short] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Boolean] :: <<?[Boolean] :: <<?[String] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Byte] :: <<?[String] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[String] :: HNil
  }
  /** Table description of table dgmEffects. Objects of this class serve as prototypes for rows in queries. */
  class Dgmeffects(_tableTag: Tag) extends Table[DgmeffectsRow](_tableTag, "dgmEffects") {
    def * = effectid :: effectname :: effectcategory :: preexpression :: postexpression :: description :: guid :: iconid :: isoffensive :: isassistance :: durationattributeid :: trackingspeedattributeid :: dischargeattributeid :: rangeattributeid :: falloffattributeid :: disallowautorepeat :: published :: displayname :: iswarpsafe :: rangechance :: electronicchance :: propulsionchance :: distribution :: sfxname :: npcusagechanceattributeid :: npcactivationchanceattributeid :: fittingusagechanceattributeid :: modifierinfo :: HNil

    /** Database column effectID SqlType(SMALLINT), PrimaryKey */
    val effectid: Rep[Short] = column[Short]("effectID", O.PrimaryKey)
    /** Database column effectName SqlType(VARCHAR), Length(400,true), Default(None) */
    val effectname: Rep[Option[String]] = column[Option[String]]("effectName", O.Length(400,varying=true), O.Default(None))
    /** Database column effectCategory SqlType(SMALLINT), Default(None) */
    val effectcategory: Rep[Option[Short]] = column[Option[Short]]("effectCategory", O.Default(None))
    /** Database column preExpression SqlType(INT), Default(None) */
    val preexpression: Rep[Option[Int]] = column[Option[Int]]("preExpression", O.Default(None))
    /** Database column postExpression SqlType(INT), Default(None) */
    val postexpression: Rep[Option[Int]] = column[Option[Int]]("postExpression", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column guid SqlType(VARCHAR), Length(60,true), Default(None) */
    val guid: Rep[Option[String]] = column[Option[String]]("guid", O.Length(60,varying=true), O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
    /** Database column isOffensive SqlType(BIT), Default(None) */
    val isoffensive: Rep[Option[Boolean]] = column[Option[Boolean]]("isOffensive", O.Default(None))
    /** Database column isAssistance SqlType(BIT), Default(None) */
    val isassistance: Rep[Option[Boolean]] = column[Option[Boolean]]("isAssistance", O.Default(None))
    /** Database column durationAttributeID SqlType(SMALLINT), Default(None) */
    val durationattributeid: Rep[Option[Short]] = column[Option[Short]]("durationAttributeID", O.Default(None))
    /** Database column trackingSpeedAttributeID SqlType(SMALLINT), Default(None) */
    val trackingspeedattributeid: Rep[Option[Short]] = column[Option[Short]]("trackingSpeedAttributeID", O.Default(None))
    /** Database column dischargeAttributeID SqlType(SMALLINT), Default(None) */
    val dischargeattributeid: Rep[Option[Short]] = column[Option[Short]]("dischargeAttributeID", O.Default(None))
    /** Database column rangeAttributeID SqlType(SMALLINT), Default(None) */
    val rangeattributeid: Rep[Option[Short]] = column[Option[Short]]("rangeAttributeID", O.Default(None))
    /** Database column falloffAttributeID SqlType(SMALLINT), Default(None) */
    val falloffattributeid: Rep[Option[Short]] = column[Option[Short]]("falloffAttributeID", O.Default(None))
    /** Database column disallowAutoRepeat SqlType(BIT), Default(None) */
    val disallowautorepeat: Rep[Option[Boolean]] = column[Option[Boolean]]("disallowAutoRepeat", O.Default(None))
    /** Database column published SqlType(BIT), Default(None) */
    val published: Rep[Option[Boolean]] = column[Option[Boolean]]("published", O.Default(None))
    /** Database column displayName SqlType(VARCHAR), Length(100,true), Default(None) */
    val displayname: Rep[Option[String]] = column[Option[String]]("displayName", O.Length(100,varying=true), O.Default(None))
    /** Database column isWarpSafe SqlType(BIT), Default(None) */
    val iswarpsafe: Rep[Option[Boolean]] = column[Option[Boolean]]("isWarpSafe", O.Default(None))
    /** Database column rangeChance SqlType(BIT), Default(None) */
    val rangechance: Rep[Option[Boolean]] = column[Option[Boolean]]("rangeChance", O.Default(None))
    /** Database column electronicChance SqlType(BIT), Default(None) */
    val electronicchance: Rep[Option[Boolean]] = column[Option[Boolean]]("electronicChance", O.Default(None))
    /** Database column propulsionChance SqlType(BIT), Default(None) */
    val propulsionchance: Rep[Option[Boolean]] = column[Option[Boolean]]("propulsionChance", O.Default(None))
    /** Database column distribution SqlType(TINYINT UNSIGNED), Default(None) */
    val distribution: Rep[Option[Byte]] = column[Option[Byte]]("distribution", O.Default(None))
    /** Database column sfxName SqlType(VARCHAR), Length(20,true), Default(None) */
    val sfxname: Rep[Option[String]] = column[Option[String]]("sfxName", O.Length(20,varying=true), O.Default(None))
    /** Database column npcUsageChanceAttributeID SqlType(SMALLINT), Default(None) */
    val npcusagechanceattributeid: Rep[Option[Short]] = column[Option[Short]]("npcUsageChanceAttributeID", O.Default(None))
    /** Database column npcActivationChanceAttributeID SqlType(SMALLINT), Default(None) */
    val npcactivationchanceattributeid: Rep[Option[Short]] = column[Option[Short]]("npcActivationChanceAttributeID", O.Default(None))
    /** Database column fittingUsageChanceAttributeID SqlType(SMALLINT), Default(None) */
    val fittingusagechanceattributeid: Rep[Option[Short]] = column[Option[Short]]("fittingUsageChanceAttributeID", O.Default(None))
    /** Database column modifierInfo SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val modifierinfo: Rep[Option[String]] = column[Option[String]]("modifierInfo", O.Length(2147483647,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Dgmeffects */
  lazy val Dgmeffects = new TableQuery(tag => new Dgmeffects(tag))

  /** Entity class storing rows of table Dgmexpressions
   *  @param expressionid Database column expressionID SqlType(INT), PrimaryKey
   *  @param operandid Database column operandID SqlType(INT), Default(None)
   *  @param arg1 Database column arg1 SqlType(INT), Default(None)
   *  @param arg2 Database column arg2 SqlType(INT), Default(None)
   *  @param expressionvalue Database column expressionValue SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param expressionname Database column expressionName SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param expressiontypeid Database column expressionTypeID SqlType(INT), Default(None)
   *  @param expressiongroupid Database column expressionGroupID SqlType(SMALLINT), Default(None)
   *  @param expressionattributeid Database column expressionAttributeID SqlType(SMALLINT), Default(None) */
  case class DgmexpressionsRow(expressionid: Int, operandid: Option[Int] = None, arg1: Option[Int] = None, arg2: Option[Int] = None, expressionvalue: Option[String] = None, description: Option[String] = None, expressionname: Option[String] = None, expressiontypeid: Option[Int] = None, expressiongroupid: Option[Short] = None, expressionattributeid: Option[Short] = None)
  /** GetResult implicit for fetching DgmexpressionsRow objects using plain SQL queries */
  implicit def GetResultDgmexpressionsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Short]]): GR[DgmexpressionsRow] = GR{
    prs => import prs._
    DgmexpressionsRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Short], <<?[Short]))
  }
  /** Table description of table dgmExpressions. Objects of this class serve as prototypes for rows in queries. */
  class Dgmexpressions(_tableTag: Tag) extends Table[DgmexpressionsRow](_tableTag, "dgmExpressions") {
    def * = (expressionid, operandid, arg1, arg2, expressionvalue, description, expressionname, expressiontypeid, expressiongroupid, expressionattributeid) <> (DgmexpressionsRow.tupled, DgmexpressionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(expressionid), operandid, arg1, arg2, expressionvalue, description, expressionname, expressiontypeid, expressiongroupid, expressionattributeid).shaped.<>({r=>import r._; _1.map(_=> DgmexpressionsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column expressionID SqlType(INT), PrimaryKey */
    val expressionid: Rep[Int] = column[Int]("expressionID", O.PrimaryKey)
    /** Database column operandID SqlType(INT), Default(None) */
    val operandid: Rep[Option[Int]] = column[Option[Int]]("operandID", O.Default(None))
    /** Database column arg1 SqlType(INT), Default(None) */
    val arg1: Rep[Option[Int]] = column[Option[Int]]("arg1", O.Default(None))
    /** Database column arg2 SqlType(INT), Default(None) */
    val arg2: Rep[Option[Int]] = column[Option[Int]]("arg2", O.Default(None))
    /** Database column expressionValue SqlType(VARCHAR), Length(100,true), Default(None) */
    val expressionvalue: Rep[Option[String]] = column[Option[String]]("expressionValue", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column expressionName SqlType(VARCHAR), Length(500,true), Default(None) */
    val expressionname: Rep[Option[String]] = column[Option[String]]("expressionName", O.Length(500,varying=true), O.Default(None))
    /** Database column expressionTypeID SqlType(INT), Default(None) */
    val expressiontypeid: Rep[Option[Int]] = column[Option[Int]]("expressionTypeID", O.Default(None))
    /** Database column expressionGroupID SqlType(SMALLINT), Default(None) */
    val expressiongroupid: Rep[Option[Short]] = column[Option[Short]]("expressionGroupID", O.Default(None))
    /** Database column expressionAttributeID SqlType(SMALLINT), Default(None) */
    val expressionattributeid: Rep[Option[Short]] = column[Option[Short]]("expressionAttributeID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Dgmexpressions */
  lazy val Dgmexpressions = new TableQuery(tag => new Dgmexpressions(tag))

  /** Entity class storing rows of table Dgmtypeattributes
   *  @param typeid Database column typeID SqlType(INT)
   *  @param attributeid Database column attributeID SqlType(SMALLINT)
   *  @param valueint Database column valueInt SqlType(INT), Default(None)
   *  @param valuefloat Database column valueFloat SqlType(DOUBLE), Default(None) */
  case class DgmtypeattributesRow(typeid: Int, attributeid: Short, valueint: Option[Int] = None, valuefloat: Option[Double] = None)
  /** GetResult implicit for fetching DgmtypeattributesRow objects using plain SQL queries */
  implicit def GetResultDgmtypeattributesRow(implicit e0: GR[Int], e1: GR[Short], e2: GR[Option[Int]], e3: GR[Option[Double]]): GR[DgmtypeattributesRow] = GR{
    prs => import prs._
    DgmtypeattributesRow.tupled((<<[Int], <<[Short], <<?[Int], <<?[Double]))
  }
  /** Table description of table dgmTypeAttributes. Objects of this class serve as prototypes for rows in queries. */
  class Dgmtypeattributes(_tableTag: Tag) extends Table[DgmtypeattributesRow](_tableTag, "dgmTypeAttributes") {
    def * = (typeid, attributeid, valueint, valuefloat) <> (DgmtypeattributesRow.tupled, DgmtypeattributesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), Rep.Some(attributeid), valueint, valuefloat).shaped.<>({r=>import r._; _1.map(_=> DgmtypeattributesRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column attributeID SqlType(SMALLINT) */
    val attributeid: Rep[Short] = column[Short]("attributeID")
    /** Database column valueInt SqlType(INT), Default(None) */
    val valueint: Rep[Option[Int]] = column[Option[Int]]("valueInt", O.Default(None))
    /** Database column valueFloat SqlType(DOUBLE), Default(None) */
    val valuefloat: Rep[Option[Double]] = column[Option[Double]]("valueFloat", O.Default(None))

    /** Primary key of Dgmtypeattributes (database name dgmTypeAttributes_PK) */
    val pk = primaryKey("dgmTypeAttributes_PK", (typeid, attributeid))
  }
  /** Collection-like TableQuery object for table Dgmtypeattributes */
  lazy val Dgmtypeattributes = new TableQuery(tag => new Dgmtypeattributes(tag))

  /** Entity class storing rows of table Dgmtypeeffects
   *  @param typeid Database column typeID SqlType(INT)
   *  @param effectid Database column effectID SqlType(SMALLINT)
   *  @param isdefault Database column isDefault SqlType(BIT), Default(None) */
  case class DgmtypeeffectsRow(typeid: Int, effectid: Short, isdefault: Option[Boolean] = None)
  /** GetResult implicit for fetching DgmtypeeffectsRow objects using plain SQL queries */
  implicit def GetResultDgmtypeeffectsRow(implicit e0: GR[Int], e1: GR[Short], e2: GR[Option[Boolean]]): GR[DgmtypeeffectsRow] = GR{
    prs => import prs._
    DgmtypeeffectsRow.tupled((<<[Int], <<[Short], <<?[Boolean]))
  }
  /** Table description of table dgmTypeEffects. Objects of this class serve as prototypes for rows in queries. */
  class Dgmtypeeffects(_tableTag: Tag) extends Table[DgmtypeeffectsRow](_tableTag, "dgmTypeEffects") {
    def * = (typeid, effectid, isdefault) <> (DgmtypeeffectsRow.tupled, DgmtypeeffectsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), Rep.Some(effectid), isdefault).shaped.<>({r=>import r._; _1.map(_=> DgmtypeeffectsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column effectID SqlType(SMALLINT) */
    val effectid: Rep[Short] = column[Short]("effectID")
    /** Database column isDefault SqlType(BIT), Default(None) */
    val isdefault: Rep[Option[Boolean]] = column[Option[Boolean]]("isDefault", O.Default(None))

    /** Primary key of Dgmtypeeffects (database name dgmTypeEffects_PK) */
    val pk = primaryKey("dgmTypeEffects_PK", (typeid, effectid))
  }
  /** Collection-like TableQuery object for table Dgmtypeeffects */
  lazy val Dgmtypeeffects = new TableQuery(tag => new Dgmtypeeffects(tag))

  /** Entity class storing rows of table Evegraphics
   *  @param graphicid Database column graphicID SqlType(INT), PrimaryKey
   *  @param soffactionname Database column sofFactionName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param graphicfile Database column graphicFile SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param sofhullname Database column sofHullName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param sofracename Database column sofRaceName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
  case class EvegraphicsRow(graphicid: Int, soffactionname: Option[String] = None, graphicfile: Option[String] = None, sofhullname: Option[String] = None, sofracename: Option[String] = None, description: Option[String] = None)
  /** GetResult implicit for fetching EvegraphicsRow objects using plain SQL queries */
  implicit def GetResultEvegraphicsRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[EvegraphicsRow] = GR{
    prs => import prs._
    EvegraphicsRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table eveGraphics. Objects of this class serve as prototypes for rows in queries. */
  class Evegraphics(_tableTag: Tag) extends Table[EvegraphicsRow](_tableTag, "eveGraphics") {
    def * = (graphicid, soffactionname, graphicfile, sofhullname, sofracename, description) <> (EvegraphicsRow.tupled, EvegraphicsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(graphicid), soffactionname, graphicfile, sofhullname, sofracename, description).shaped.<>({r=>import r._; _1.map(_=> EvegraphicsRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column graphicID SqlType(INT), PrimaryKey */
    val graphicid: Rep[Int] = column[Int]("graphicID", O.PrimaryKey)
    /** Database column sofFactionName SqlType(VARCHAR), Length(100,true), Default(None) */
    val soffactionname: Rep[Option[String]] = column[Option[String]]("sofFactionName", O.Length(100,varying=true), O.Default(None))
    /** Database column graphicFile SqlType(VARCHAR), Length(100,true), Default(None) */
    val graphicfile: Rep[Option[String]] = column[Option[String]]("graphicFile", O.Length(100,varying=true), O.Default(None))
    /** Database column sofHullName SqlType(VARCHAR), Length(100,true), Default(None) */
    val sofhullname: Rep[Option[String]] = column[Option[String]]("sofHullName", O.Length(100,varying=true), O.Default(None))
    /** Database column sofRaceName SqlType(VARCHAR), Length(100,true), Default(None) */
    val sofracename: Rep[Option[String]] = column[Option[String]]("sofRaceName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(2147483647,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Evegraphics */
  lazy val Evegraphics = new TableQuery(tag => new Evegraphics(tag))

  /** Entity class storing rows of table Eveicons
   *  @param iconid Database column iconID SqlType(INT), PrimaryKey
   *  @param iconfile Database column iconFile SqlType(VARCHAR), Length(500,true), Default(None)
   *  @param description Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
  case class EveiconsRow(iconid: Int, iconfile: Option[String] = None, description: Option[String] = None)
  /** GetResult implicit for fetching EveiconsRow objects using plain SQL queries */
  implicit def GetResultEveiconsRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[EveiconsRow] = GR{
    prs => import prs._
    EveiconsRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table eveIcons. Objects of this class serve as prototypes for rows in queries. */
  class Eveicons(_tableTag: Tag) extends Table[EveiconsRow](_tableTag, "eveIcons") {
    def * = (iconid, iconfile, description) <> (EveiconsRow.tupled, EveiconsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(iconid), iconfile, description).shaped.<>({r=>import r._; _1.map(_=> EveiconsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column iconID SqlType(INT), PrimaryKey */
    val iconid: Rep[Int] = column[Int]("iconID", O.PrimaryKey)
    /** Database column iconFile SqlType(VARCHAR), Length(500,true), Default(None) */
    val iconfile: Rep[Option[String]] = column[Option[String]]("iconFile", O.Length(500,varying=true), O.Default(None))
    /** Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(2147483647,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Eveicons */
  lazy val Eveicons = new TableQuery(tag => new Eveicons(tag))

  /** Entity class storing rows of table Eveunits
   *  @param unitid Database column unitID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param unitname Database column unitName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param displayname Database column displayName SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
  case class EveunitsRow(unitid: Byte, unitname: Option[String] = None, displayname: Option[String] = None, description: Option[String] = None)
  /** GetResult implicit for fetching EveunitsRow objects using plain SQL queries */
  implicit def GetResultEveunitsRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[EveunitsRow] = GR{
    prs => import prs._
    EveunitsRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table eveUnits. Objects of this class serve as prototypes for rows in queries. */
  class Eveunits(_tableTag: Tag) extends Table[EveunitsRow](_tableTag, "eveUnits") {
    def * = (unitid, unitname, displayname, description) <> (EveunitsRow.tupled, EveunitsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(unitid), unitname, displayname, description).shaped.<>({r=>import r._; _1.map(_=> EveunitsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column unitID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val unitid: Rep[Byte] = column[Byte]("unitID", O.PrimaryKey)
    /** Database column unitName SqlType(VARCHAR), Length(100,true), Default(None) */
    val unitname: Rep[Option[String]] = column[Option[String]]("unitName", O.Length(100,varying=true), O.Default(None))
    /** Database column displayName SqlType(VARCHAR), Length(50,true), Default(None) */
    val displayname: Rep[Option[String]] = column[Option[String]]("displayName", O.Length(50,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Eveunits */
  lazy val Eveunits = new TableQuery(tag => new Eveunits(tag))

  /** Entity class storing rows of table Industryactivity
   *  @param typeid Database column typeID SqlType(INT)
   *  @param activityid Database column activityID SqlType(INT)
   *  @param time Database column time SqlType(INT), Default(None) */
  case class IndustryactivityRow(typeid: Int, activityid: Int, time: Option[Int] = None)
  /** GetResult implicit for fetching IndustryactivityRow objects using plain SQL queries */
  implicit def GetResultIndustryactivityRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[IndustryactivityRow] = GR{
    prs => import prs._
    IndustryactivityRow.tupled((<<[Int], <<[Int], <<?[Int]))
  }
  /** Table description of table industryActivity. Objects of this class serve as prototypes for rows in queries. */
  class Industryactivity(_tableTag: Tag) extends Table[IndustryactivityRow](_tableTag, "industryActivity") {
    def * = (typeid, activityid, time) <> (IndustryactivityRow.tupled, IndustryactivityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), Rep.Some(activityid), time).shaped.<>({r=>import r._; _1.map(_=> IndustryactivityRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column activityID SqlType(INT) */
    val activityid: Rep[Int] = column[Int]("activityID")
    /** Database column time SqlType(INT), Default(None) */
    val time: Rep[Option[Int]] = column[Option[Int]]("time", O.Default(None))

    /** Primary key of Industryactivity (database name industryActivity_PK) */
    val pk = primaryKey("industryActivity_PK", (typeid, activityid))

    /** Index over (activityid) (database name ix_industryActivity_activityID) */
    val index1 = index("ix_industryActivity_activityID", activityid)
  }
  /** Collection-like TableQuery object for table Industryactivity */
  lazy val Industryactivity = new TableQuery(tag => new Industryactivity(tag))

  /** Entity class storing rows of table Industryactivitymaterials
   *  @param typeid Database column typeID SqlType(INT), Default(None)
   *  @param activityid Database column activityID SqlType(INT), Default(None)
   *  @param materialtypeid Database column materialTypeID SqlType(INT), Default(None)
   *  @param quantity Database column quantity SqlType(INT), Default(None) */
  case class IndustryactivitymaterialsRow(typeid: Option[Int] = None, activityid: Option[Int] = None, materialtypeid: Option[Int] = None, quantity: Option[Int] = None)
  /** GetResult implicit for fetching IndustryactivitymaterialsRow objects using plain SQL queries */
  implicit def GetResultIndustryactivitymaterialsRow(implicit e0: GR[Option[Int]]): GR[IndustryactivitymaterialsRow] = GR{
    prs => import prs._
    IndustryactivitymaterialsRow.tupled((<<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table industryActivityMaterials. Objects of this class serve as prototypes for rows in queries. */
  class Industryactivitymaterials(_tableTag: Tag) extends Table[IndustryactivitymaterialsRow](_tableTag, "industryActivityMaterials") {
    def * = (typeid, activityid, materialtypeid, quantity) <> (IndustryactivitymaterialsRow.tupled, IndustryactivitymaterialsRow.unapply)

    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))
    /** Database column activityID SqlType(INT), Default(None) */
    val activityid: Rep[Option[Int]] = column[Option[Int]]("activityID", O.Default(None))
    /** Database column materialTypeID SqlType(INT), Default(None) */
    val materialtypeid: Rep[Option[Int]] = column[Option[Int]]("materialTypeID", O.Default(None))
    /** Database column quantity SqlType(INT), Default(None) */
    val quantity: Rep[Option[Int]] = column[Option[Int]]("quantity", O.Default(None))

    /** Index over (typeid,activityid) (database name industryActivityMaterials_idx1) */
    val index1 = index("industryActivityMaterials_idx1", (typeid, activityid))
    /** Index over (typeid) (database name ix_industryActivityMaterials_typeID) */
    val index2 = index("ix_industryActivityMaterials_typeID", typeid)
  }
  /** Collection-like TableQuery object for table Industryactivitymaterials */
  lazy val Industryactivitymaterials = new TableQuery(tag => new Industryactivitymaterials(tag))

  /** Entity class storing rows of table Industryactivityprobabilities
   *  @param typeid Database column typeID SqlType(INT), Default(None)
   *  @param activityid Database column activityID SqlType(INT), Default(None)
   *  @param producttypeid Database column productTypeID SqlType(INT), Default(None)
   *  @param probability Database column probability SqlType(DECIMAL), Default(None) */
  case class IndustryactivityprobabilitiesRow(typeid: Option[Int] = None, activityid: Option[Int] = None, producttypeid: Option[Int] = None, probability: Option[scala.math.BigDecimal] = None)
  /** GetResult implicit for fetching IndustryactivityprobabilitiesRow objects using plain SQL queries */
  implicit def GetResultIndustryactivityprobabilitiesRow(implicit e0: GR[Option[Int]], e1: GR[Option[scala.math.BigDecimal]]): GR[IndustryactivityprobabilitiesRow] = GR{
    prs => import prs._
    IndustryactivityprobabilitiesRow.tupled((<<?[Int], <<?[Int], <<?[Int], <<?[scala.math.BigDecimal]))
  }
  /** Table description of table industryActivityProbabilities. Objects of this class serve as prototypes for rows in queries. */
  class Industryactivityprobabilities(_tableTag: Tag) extends Table[IndustryactivityprobabilitiesRow](_tableTag, "industryActivityProbabilities") {
    def * = (typeid, activityid, producttypeid, probability) <> (IndustryactivityprobabilitiesRow.tupled, IndustryactivityprobabilitiesRow.unapply)

    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))
    /** Database column activityID SqlType(INT), Default(None) */
    val activityid: Rep[Option[Int]] = column[Option[Int]]("activityID", O.Default(None))
    /** Database column productTypeID SqlType(INT), Default(None) */
    val producttypeid: Rep[Option[Int]] = column[Option[Int]]("productTypeID", O.Default(None))
    /** Database column probability SqlType(DECIMAL), Default(None) */
    val probability: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("probability", O.Default(None))

    /** Index over (producttypeid) (database name ix_industryActivityProbabilities_productTypeID) */
    val index1 = index("ix_industryActivityProbabilities_productTypeID", producttypeid)
    /** Index over (typeid) (database name ix_industryActivityProbabilities_typeID) */
    val index2 = index("ix_industryActivityProbabilities_typeID", typeid)
  }
  /** Collection-like TableQuery object for table Industryactivityprobabilities */
  lazy val Industryactivityprobabilities = new TableQuery(tag => new Industryactivityprobabilities(tag))

  /** Entity class storing rows of table Industryactivityproducts
   *  @param typeid Database column typeID SqlType(INT), Default(None)
   *  @param activityid Database column activityID SqlType(INT), Default(None)
   *  @param producttypeid Database column productTypeID SqlType(INT), Default(None)
   *  @param quantity Database column quantity SqlType(INT), Default(None) */
  case class IndustryactivityproductsRow(typeid: Option[Int] = None, activityid: Option[Int] = None, producttypeid: Option[Int] = None, quantity: Option[Int] = None)
  /** GetResult implicit for fetching IndustryactivityproductsRow objects using plain SQL queries */
  implicit def GetResultIndustryactivityproductsRow(implicit e0: GR[Option[Int]]): GR[IndustryactivityproductsRow] = GR{
    prs => import prs._
    IndustryactivityproductsRow.tupled((<<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table industryActivityProducts. Objects of this class serve as prototypes for rows in queries. */
  class Industryactivityproducts(_tableTag: Tag) extends Table[IndustryactivityproductsRow](_tableTag, "industryActivityProducts") {
    def * = (typeid, activityid, producttypeid, quantity) <> (IndustryactivityproductsRow.tupled, IndustryactivityproductsRow.unapply)

    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))
    /** Database column activityID SqlType(INT), Default(None) */
    val activityid: Rep[Option[Int]] = column[Option[Int]]("activityID", O.Default(None))
    /** Database column productTypeID SqlType(INT), Default(None) */
    val producttypeid: Rep[Option[Int]] = column[Option[Int]]("productTypeID", O.Default(None))
    /** Database column quantity SqlType(INT), Default(None) */
    val quantity: Rep[Option[Int]] = column[Option[Int]]("quantity", O.Default(None))

    /** Index over (typeid,activityid) (database name industryActivityProduct_idx1) */
    val index1 = index("industryActivityProduct_idx1", (typeid, activityid))
    /** Index over (producttypeid) (database name ix_industryActivityProducts_productTypeID) */
    val index2 = index("ix_industryActivityProducts_productTypeID", producttypeid)
    /** Index over (typeid) (database name ix_industryActivityProducts_typeID) */
    val index3 = index("ix_industryActivityProducts_typeID", typeid)
  }
  /** Collection-like TableQuery object for table Industryactivityproducts */
  lazy val Industryactivityproducts = new TableQuery(tag => new Industryactivityproducts(tag))

  /** Entity class storing rows of table Industryactivityskills
   *  @param typeid Database column typeID SqlType(INT), Default(None)
   *  @param activityid Database column activityID SqlType(INT), Default(None)
   *  @param skillid Database column skillID SqlType(INT), Default(None)
   *  @param level Database column level SqlType(INT), Default(None) */
  case class IndustryactivityskillsRow(typeid: Option[Int] = None, activityid: Option[Int] = None, skillid: Option[Int] = None, level: Option[Int] = None)
  /** GetResult implicit for fetching IndustryactivityskillsRow objects using plain SQL queries */
  implicit def GetResultIndustryactivityskillsRow(implicit e0: GR[Option[Int]]): GR[IndustryactivityskillsRow] = GR{
    prs => import prs._
    IndustryactivityskillsRow.tupled((<<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table industryActivitySkills. Objects of this class serve as prototypes for rows in queries. */
  class Industryactivityskills(_tableTag: Tag) extends Table[IndustryactivityskillsRow](_tableTag, "industryActivitySkills") {
    def * = (typeid, activityid, skillid, level) <> (IndustryactivityskillsRow.tupled, IndustryactivityskillsRow.unapply)

    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))
    /** Database column activityID SqlType(INT), Default(None) */
    val activityid: Rep[Option[Int]] = column[Option[Int]]("activityID", O.Default(None))
    /** Database column skillID SqlType(INT), Default(None) */
    val skillid: Rep[Option[Int]] = column[Option[Int]]("skillID", O.Default(None))
    /** Database column level SqlType(INT), Default(None) */
    val level: Rep[Option[Int]] = column[Option[Int]]("level", O.Default(None))

    /** Index over (typeid,activityid) (database name industryActivitySkills_idx1) */
    val index1 = index("industryActivitySkills_idx1", (typeid, activityid))
    /** Index over (skillid) (database name ix_industryActivitySkills_skillID) */
    val index2 = index("ix_industryActivitySkills_skillID", skillid)
    /** Index over (typeid) (database name ix_industryActivitySkills_typeID) */
    val index3 = index("ix_industryActivitySkills_typeID", typeid)
  }
  /** Collection-like TableQuery object for table Industryactivityskills */
  lazy val Industryactivityskills = new TableQuery(tag => new Industryactivityskills(tag))

  /** Entity class storing rows of table Industryblueprints
   *  @param typeid Database column typeID SqlType(INT), PrimaryKey
   *  @param maxproductionlimit Database column maxProductionLimit SqlType(INT), Default(None) */
  case class IndustryblueprintsRow(typeid: Int, maxproductionlimit: Option[Int] = None)
  /** GetResult implicit for fetching IndustryblueprintsRow objects using plain SQL queries */
  implicit def GetResultIndustryblueprintsRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[IndustryblueprintsRow] = GR{
    prs => import prs._
    IndustryblueprintsRow.tupled((<<[Int], <<?[Int]))
  }
  /** Table description of table industryBlueprints. Objects of this class serve as prototypes for rows in queries. */
  class Industryblueprints(_tableTag: Tag) extends Table[IndustryblueprintsRow](_tableTag, "industryBlueprints") {
    def * = (typeid, maxproductionlimit) <> (IndustryblueprintsRow.tupled, IndustryblueprintsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), maxproductionlimit).shaped.<>({r=>import r._; _1.map(_=> IndustryblueprintsRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column typeID SqlType(INT), PrimaryKey */
    val typeid: Rep[Int] = column[Int]("typeID", O.PrimaryKey)
    /** Database column maxProductionLimit SqlType(INT), Default(None) */
    val maxproductionlimit: Rep[Option[Int]] = column[Option[Int]]("maxProductionLimit", O.Default(None))
  }
  /** Collection-like TableQuery object for table Industryblueprints */
  lazy val Industryblueprints = new TableQuery(tag => new Industryblueprints(tag))

  /** Entity class storing rows of table Invcategories
   *  @param categoryid Database column categoryID SqlType(INT), PrimaryKey
   *  @param categoryname Database column categoryName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param iconid Database column iconID SqlType(BIGINT), Default(None)
   *  @param published Database column published SqlType(BIT), Default(None) */
  case class InvcategoriesRow(categoryid: Int, categoryname: Option[String] = None, iconid: Option[Long] = None, published: Option[Boolean] = None)
  /** GetResult implicit for fetching InvcategoriesRow objects using plain SQL queries */
  implicit def GetResultInvcategoriesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[Boolean]]): GR[InvcategoriesRow] = GR{
    prs => import prs._
    InvcategoriesRow.tupled((<<[Int], <<?[String], <<?[Long], <<?[Boolean]))
  }
  /** Table description of table invCategories. Objects of this class serve as prototypes for rows in queries. */
  class Invcategories(_tableTag: Tag) extends Table[InvcategoriesRow](_tableTag, "invCategories") {
    def * = (categoryid, categoryname, iconid, published) <> (InvcategoriesRow.tupled, InvcategoriesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(categoryid), categoryname, iconid, published).shaped.<>({r=>import r._; _1.map(_=> InvcategoriesRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column categoryID SqlType(INT), PrimaryKey */
    val categoryid: Rep[Int] = column[Int]("categoryID", O.PrimaryKey)
    /** Database column categoryName SqlType(VARCHAR), Length(100,true), Default(None) */
    val categoryname: Rep[Option[String]] = column[Option[String]]("categoryName", O.Length(100,varying=true), O.Default(None))
    /** Database column iconID SqlType(BIGINT), Default(None) */
    val iconid: Rep[Option[Long]] = column[Option[Long]]("iconID", O.Default(None))
    /** Database column published SqlType(BIT), Default(None) */
    val published: Rep[Option[Boolean]] = column[Option[Boolean]]("published", O.Default(None))
  }
  /** Collection-like TableQuery object for table Invcategories */
  lazy val Invcategories = new TableQuery(tag => new Invcategories(tag))

  /** Entity class storing rows of table Invcontrabandtypes
   *  @param factionid Database column factionID SqlType(INT)
   *  @param typeid Database column typeID SqlType(INT)
   *  @param standingloss Database column standingLoss SqlType(DOUBLE), Default(None)
   *  @param confiscateminsec Database column confiscateMinSec SqlType(DOUBLE), Default(None)
   *  @param finebyvalue Database column fineByValue SqlType(DOUBLE), Default(None)
   *  @param attackminsec Database column attackMinSec SqlType(DOUBLE), Default(None) */
  case class InvcontrabandtypesRow(factionid: Int, typeid: Int, standingloss: Option[Double] = None, confiscateminsec: Option[Double] = None, finebyvalue: Option[Double] = None, attackminsec: Option[Double] = None)
  /** GetResult implicit for fetching InvcontrabandtypesRow objects using plain SQL queries */
  implicit def GetResultInvcontrabandtypesRow(implicit e0: GR[Int], e1: GR[Option[Double]]): GR[InvcontrabandtypesRow] = GR{
    prs => import prs._
    InvcontrabandtypesRow.tupled((<<[Int], <<[Int], <<?[Double], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table invContrabandTypes. Objects of this class serve as prototypes for rows in queries. */
  class Invcontrabandtypes(_tableTag: Tag) extends Table[InvcontrabandtypesRow](_tableTag, "invContrabandTypes") {
    def * = (factionid, typeid, standingloss, confiscateminsec, finebyvalue, attackminsec) <> (InvcontrabandtypesRow.tupled, InvcontrabandtypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(factionid), Rep.Some(typeid), standingloss, confiscateminsec, finebyvalue, attackminsec).shaped.<>({r=>import r._; _1.map(_=> InvcontrabandtypesRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column factionID SqlType(INT) */
    val factionid: Rep[Int] = column[Int]("factionID")
    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column standingLoss SqlType(DOUBLE), Default(None) */
    val standingloss: Rep[Option[Double]] = column[Option[Double]]("standingLoss", O.Default(None))
    /** Database column confiscateMinSec SqlType(DOUBLE), Default(None) */
    val confiscateminsec: Rep[Option[Double]] = column[Option[Double]]("confiscateMinSec", O.Default(None))
    /** Database column fineByValue SqlType(DOUBLE), Default(None) */
    val finebyvalue: Rep[Option[Double]] = column[Option[Double]]("fineByValue", O.Default(None))
    /** Database column attackMinSec SqlType(DOUBLE), Default(None) */
    val attackminsec: Rep[Option[Double]] = column[Option[Double]]("attackMinSec", O.Default(None))

    /** Primary key of Invcontrabandtypes (database name invContrabandTypes_PK) */
    val pk = primaryKey("invContrabandTypes_PK", (factionid, typeid))

    /** Index over (typeid) (database name invContrabandTypes_IX_type) */
    val index1 = index("invContrabandTypes_IX_type", typeid)
  }
  /** Collection-like TableQuery object for table Invcontrabandtypes */
  lazy val Invcontrabandtypes = new TableQuery(tag => new Invcontrabandtypes(tag))

  /** Entity class storing rows of table Invcontroltowerresourcepurposes
   *  @param purpose Database column purpose SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param purposetext Database column purposeText SqlType(VARCHAR), Length(100,true), Default(None) */
  case class InvcontroltowerresourcepurposesRow(purpose: Byte, purposetext: Option[String] = None)
  /** GetResult implicit for fetching InvcontroltowerresourcepurposesRow objects using plain SQL queries */
  implicit def GetResultInvcontroltowerresourcepurposesRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[InvcontroltowerresourcepurposesRow] = GR{
    prs => import prs._
    InvcontroltowerresourcepurposesRow.tupled((<<[Byte], <<?[String]))
  }
  /** Table description of table invControlTowerResourcePurposes. Objects of this class serve as prototypes for rows in queries. */
  class Invcontroltowerresourcepurposes(_tableTag: Tag) extends Table[InvcontroltowerresourcepurposesRow](_tableTag, "invControlTowerResourcePurposes") {
    def * = (purpose, purposetext) <> (InvcontroltowerresourcepurposesRow.tupled, InvcontroltowerresourcepurposesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(purpose), purposetext).shaped.<>({r=>import r._; _1.map(_=> InvcontroltowerresourcepurposesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column purpose SqlType(TINYINT UNSIGNED), PrimaryKey */
    val purpose: Rep[Byte] = column[Byte]("purpose", O.PrimaryKey)
    /** Database column purposeText SqlType(VARCHAR), Length(100,true), Default(None) */
    val purposetext: Rep[Option[String]] = column[Option[String]]("purposeText", O.Length(100,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Invcontroltowerresourcepurposes */
  lazy val Invcontroltowerresourcepurposes = new TableQuery(tag => new Invcontroltowerresourcepurposes(tag))

  /** Entity class storing rows of table Invcontroltowerresources
   *  @param controltowertypeid Database column controlTowerTypeID SqlType(INT)
   *  @param resourcetypeid Database column resourceTypeID SqlType(INT)
   *  @param purpose Database column purpose SqlType(TINYINT UNSIGNED), Default(None)
   *  @param quantity Database column quantity SqlType(INT), Default(None)
   *  @param minsecuritylevel Database column minSecurityLevel SqlType(DOUBLE), Default(None)
   *  @param factionid Database column factionID SqlType(INT), Default(None) */
  case class InvcontroltowerresourcesRow(controltowertypeid: Int, resourcetypeid: Int, purpose: Option[Byte] = None, quantity: Option[Int] = None, minsecuritylevel: Option[Double] = None, factionid: Option[Int] = None)
  /** GetResult implicit for fetching InvcontroltowerresourcesRow objects using plain SQL queries */
  implicit def GetResultInvcontroltowerresourcesRow(implicit e0: GR[Int], e1: GR[Option[Byte]], e2: GR[Option[Int]], e3: GR[Option[Double]]): GR[InvcontroltowerresourcesRow] = GR{
    prs => import prs._
    InvcontroltowerresourcesRow.tupled((<<[Int], <<[Int], <<?[Byte], <<?[Int], <<?[Double], <<?[Int]))
  }
  /** Table description of table invControlTowerResources. Objects of this class serve as prototypes for rows in queries. */
  class Invcontroltowerresources(_tableTag: Tag) extends Table[InvcontroltowerresourcesRow](_tableTag, "invControlTowerResources") {
    def * = (controltowertypeid, resourcetypeid, purpose, quantity, minsecuritylevel, factionid) <> (InvcontroltowerresourcesRow.tupled, InvcontroltowerresourcesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(controltowertypeid), Rep.Some(resourcetypeid), purpose, quantity, minsecuritylevel, factionid).shaped.<>({r=>import r._; _1.map(_=> InvcontroltowerresourcesRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column controlTowerTypeID SqlType(INT) */
    val controltowertypeid: Rep[Int] = column[Int]("controlTowerTypeID")
    /** Database column resourceTypeID SqlType(INT) */
    val resourcetypeid: Rep[Int] = column[Int]("resourceTypeID")
    /** Database column purpose SqlType(TINYINT UNSIGNED), Default(None) */
    val purpose: Rep[Option[Byte]] = column[Option[Byte]]("purpose", O.Default(None))
    /** Database column quantity SqlType(INT), Default(None) */
    val quantity: Rep[Option[Int]] = column[Option[Int]]("quantity", O.Default(None))
    /** Database column minSecurityLevel SqlType(DOUBLE), Default(None) */
    val minsecuritylevel: Rep[Option[Double]] = column[Option[Double]]("minSecurityLevel", O.Default(None))
    /** Database column factionID SqlType(INT), Default(None) */
    val factionid: Rep[Option[Int]] = column[Option[Int]]("factionID", O.Default(None))

    /** Primary key of Invcontroltowerresources (database name invControlTowerResources_PK) */
    val pk = primaryKey("invControlTowerResources_PK", (controltowertypeid, resourcetypeid))
  }
  /** Collection-like TableQuery object for table Invcontroltowerresources */
  lazy val Invcontroltowerresources = new TableQuery(tag => new Invcontroltowerresources(tag))

  /** Entity class storing rows of table Invflags
   *  @param flagid Database column flagID SqlType(SMALLINT), PrimaryKey
   *  @param flagname Database column flagName SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param flagtext Database column flagText SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param orderid Database column orderID SqlType(INT), Default(None) */
  case class InvflagsRow(flagid: Short, flagname: Option[String] = None, flagtext: Option[String] = None, orderid: Option[Int] = None)
  /** GetResult implicit for fetching InvflagsRow objects using plain SQL queries */
  implicit def GetResultInvflagsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[InvflagsRow] = GR{
    prs => import prs._
    InvflagsRow.tupled((<<[Short], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table invFlags. Objects of this class serve as prototypes for rows in queries. */
  class Invflags(_tableTag: Tag) extends Table[InvflagsRow](_tableTag, "invFlags") {
    def * = (flagid, flagname, flagtext, orderid) <> (InvflagsRow.tupled, InvflagsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(flagid), flagname, flagtext, orderid).shaped.<>({r=>import r._; _1.map(_=> InvflagsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column flagID SqlType(SMALLINT), PrimaryKey */
    val flagid: Rep[Short] = column[Short]("flagID", O.PrimaryKey)
    /** Database column flagName SqlType(VARCHAR), Length(200,true), Default(None) */
    val flagname: Rep[Option[String]] = column[Option[String]]("flagName", O.Length(200,varying=true), O.Default(None))
    /** Database column flagText SqlType(VARCHAR), Length(100,true), Default(None) */
    val flagtext: Rep[Option[String]] = column[Option[String]]("flagText", O.Length(100,varying=true), O.Default(None))
    /** Database column orderID SqlType(INT), Default(None) */
    val orderid: Rep[Option[Int]] = column[Option[Int]]("orderID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Invflags */
  lazy val Invflags = new TableQuery(tag => new Invflags(tag))

  /** Entity class storing rows of table Invgroups
   *  @param groupid Database column groupID SqlType(INT), PrimaryKey
   *  @param categoryid Database column categoryID SqlType(INT), Default(None)
   *  @param groupname Database column groupName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param iconid Database column iconID SqlType(BIGINT), Default(None)
   *  @param usebaseprice Database column useBasePrice SqlType(BIT), Default(None)
   *  @param anchored Database column anchored SqlType(BIT), Default(None)
   *  @param anchorable Database column anchorable SqlType(BIT), Default(None)
   *  @param fittablenonsingleton Database column fittableNonSingleton SqlType(BIT), Default(None)
   *  @param published Database column published SqlType(BIT), Default(None) */
  case class InvgroupsRow(groupid: Int, categoryid: Option[Int] = None, groupname: Option[String] = None, iconid: Option[Long] = None, usebaseprice: Option[Boolean] = None, anchored: Option[Boolean] = None, anchorable: Option[Boolean] = None, fittablenonsingleton: Option[Boolean] = None, published: Option[Boolean] = None)
  /** GetResult implicit for fetching InvgroupsRow objects using plain SQL queries */
  implicit def GetResultInvgroupsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Long]], e4: GR[Option[Boolean]]): GR[InvgroupsRow] = GR{
    prs => import prs._
    InvgroupsRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[Long], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean]))
  }
  /** Table description of table invGroups. Objects of this class serve as prototypes for rows in queries. */
  class Invgroups(_tableTag: Tag) extends Table[InvgroupsRow](_tableTag, "invGroups") {
    def * = (groupid, categoryid, groupname, iconid, usebaseprice, anchored, anchorable, fittablenonsingleton, published) <> (InvgroupsRow.tupled, InvgroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(groupid), categoryid, groupname, iconid, usebaseprice, anchored, anchorable, fittablenonsingleton, published).shaped.<>({r=>import r._; _1.map(_=> InvgroupsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column groupID SqlType(INT), PrimaryKey */
    val groupid: Rep[Int] = column[Int]("groupID", O.PrimaryKey)
    /** Database column categoryID SqlType(INT), Default(None) */
    val categoryid: Rep[Option[Int]] = column[Option[Int]]("categoryID", O.Default(None))
    /** Database column groupName SqlType(VARCHAR), Length(100,true), Default(None) */
    val groupname: Rep[Option[String]] = column[Option[String]]("groupName", O.Length(100,varying=true), O.Default(None))
    /** Database column iconID SqlType(BIGINT), Default(None) */
    val iconid: Rep[Option[Long]] = column[Option[Long]]("iconID", O.Default(None))
    /** Database column useBasePrice SqlType(BIT), Default(None) */
    val usebaseprice: Rep[Option[Boolean]] = column[Option[Boolean]]("useBasePrice", O.Default(None))
    /** Database column anchored SqlType(BIT), Default(None) */
    val anchored: Rep[Option[Boolean]] = column[Option[Boolean]]("anchored", O.Default(None))
    /** Database column anchorable SqlType(BIT), Default(None) */
    val anchorable: Rep[Option[Boolean]] = column[Option[Boolean]]("anchorable", O.Default(None))
    /** Database column fittableNonSingleton SqlType(BIT), Default(None) */
    val fittablenonsingleton: Rep[Option[Boolean]] = column[Option[Boolean]]("fittableNonSingleton", O.Default(None))
    /** Database column published SqlType(BIT), Default(None) */
    val published: Rep[Option[Boolean]] = column[Option[Boolean]]("published", O.Default(None))

    /** Index over (categoryid) (database name invTypes_categoryid) */
    val index1 = index("invTypes_categoryid", categoryid)
  }
  /** Collection-like TableQuery object for table Invgroups */
  lazy val Invgroups = new TableQuery(tag => new Invgroups(tag))

  /** Entity class storing rows of table Invitems
   *  @param itemid Database column itemID SqlType(BIGINT), PrimaryKey
   *  @param typeid Database column typeID SqlType(INT)
   *  @param ownerid Database column ownerID SqlType(INT)
   *  @param locationid Database column locationID SqlType(BIGINT)
   *  @param flagid Database column flagID SqlType(SMALLINT)
   *  @param quantity Database column quantity SqlType(INT) */
  case class InvitemsRow(itemid: Long, typeid: Int, ownerid: Int, locationid: Long, flagid: Short, quantity: Int)
  /** GetResult implicit for fetching InvitemsRow objects using plain SQL queries */
  implicit def GetResultInvitemsRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[Short]): GR[InvitemsRow] = GR{
    prs => import prs._
    InvitemsRow.tupled((<<[Long], <<[Int], <<[Int], <<[Long], <<[Short], <<[Int]))
  }
  /** Table description of table invItems. Objects of this class serve as prototypes for rows in queries. */
  class Invitems(_tableTag: Tag) extends Table[InvitemsRow](_tableTag, "invItems") {
    def * = (itemid, typeid, ownerid, locationid, flagid, quantity) <> (InvitemsRow.tupled, InvitemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(itemid), Rep.Some(typeid), Rep.Some(ownerid), Rep.Some(locationid), Rep.Some(flagid), Rep.Some(quantity)).shaped.<>({r=>import r._; _1.map(_=> InvitemsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column itemID SqlType(BIGINT), PrimaryKey */
    val itemid: Rep[Long] = column[Long]("itemID", O.PrimaryKey)
    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column ownerID SqlType(INT) */
    val ownerid: Rep[Int] = column[Int]("ownerID")
    /** Database column locationID SqlType(BIGINT) */
    val locationid: Rep[Long] = column[Long]("locationID")
    /** Database column flagID SqlType(SMALLINT) */
    val flagid: Rep[Short] = column[Short]("flagID")
    /** Database column quantity SqlType(INT) */
    val quantity: Rep[Int] = column[Int]("quantity")

    /** Index over (locationid) (database name items_IX_Location) */
    val index1 = index("items_IX_Location", locationid)
    /** Index over (ownerid,locationid) (database name items_IX_OwnerLocation) */
    val index2 = index("items_IX_OwnerLocation", (ownerid, locationid))
  }
  /** Collection-like TableQuery object for table Invitems */
  lazy val Invitems = new TableQuery(tag => new Invitems(tag))

  /** Entity class storing rows of table Invmarketgroups
   *  @param marketgroupid Database column marketGroupID SqlType(INT), PrimaryKey
   *  @param parentgroupid Database column parentGroupID SqlType(INT), Default(None)
   *  @param marketgroupname Database column marketGroupName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(3000,true), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None)
   *  @param hastypes Database column hasTypes SqlType(BIT), Default(None) */
  case class InvmarketgroupsRow(marketgroupid: Int, parentgroupid: Option[Int] = None, marketgroupname: Option[String] = None, description: Option[String] = None, iconid: Option[Int] = None, hastypes: Option[Boolean] = None)
  /** GetResult implicit for fetching InvmarketgroupsRow objects using plain SQL queries */
  implicit def GetResultInvmarketgroupsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[InvmarketgroupsRow] = GR{
    prs => import prs._
    InvmarketgroupsRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Boolean]))
  }
  /** Table description of table invMarketGroups. Objects of this class serve as prototypes for rows in queries. */
  class Invmarketgroups(_tableTag: Tag) extends Table[InvmarketgroupsRow](_tableTag, "invMarketGroups") {
    def * = (marketgroupid, parentgroupid, marketgroupname, description, iconid, hastypes) <> (InvmarketgroupsRow.tupled, InvmarketgroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(marketgroupid), parentgroupid, marketgroupname, description, iconid, hastypes).shaped.<>({r=>import r._; _1.map(_=> InvmarketgroupsRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column marketGroupID SqlType(INT), PrimaryKey */
    val marketgroupid: Rep[Int] = column[Int]("marketGroupID", O.PrimaryKey)
    /** Database column parentGroupID SqlType(INT), Default(None) */
    val parentgroupid: Rep[Option[Int]] = column[Option[Int]]("parentGroupID", O.Default(None))
    /** Database column marketGroupName SqlType(VARCHAR), Length(100,true), Default(None) */
    val marketgroupname: Rep[Option[String]] = column[Option[String]]("marketGroupName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(3000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(3000,varying=true), O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
    /** Database column hasTypes SqlType(BIT), Default(None) */
    val hastypes: Rep[Option[Boolean]] = column[Option[Boolean]]("hasTypes", O.Default(None))
  }
  /** Collection-like TableQuery object for table Invmarketgroups */
  lazy val Invmarketgroups = new TableQuery(tag => new Invmarketgroups(tag))

  /** Entity class storing rows of table Invmetagroups
   *  @param metagroupid Database column metaGroupID SqlType(SMALLINT), PrimaryKey
   *  @param metagroupname Database column metaGroupName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param iconid Database column iconID SqlType(INT), Default(None) */
  case class InvmetagroupsRow(metagroupid: Short, metagroupname: Option[String] = None, description: Option[String] = None, iconid: Option[Int] = None)
  /** GetResult implicit for fetching InvmetagroupsRow objects using plain SQL queries */
  implicit def GetResultInvmetagroupsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[InvmetagroupsRow] = GR{
    prs => import prs._
    InvmetagroupsRow.tupled((<<[Short], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table invMetaGroups. Objects of this class serve as prototypes for rows in queries. */
  class Invmetagroups(_tableTag: Tag) extends Table[InvmetagroupsRow](_tableTag, "invMetaGroups") {
    def * = (metagroupid, metagroupname, description, iconid) <> (InvmetagroupsRow.tupled, InvmetagroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(metagroupid), metagroupname, description, iconid).shaped.<>({r=>import r._; _1.map(_=> InvmetagroupsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column metaGroupID SqlType(SMALLINT), PrimaryKey */
    val metagroupid: Rep[Short] = column[Short]("metaGroupID", O.PrimaryKey)
    /** Database column metaGroupName SqlType(VARCHAR), Length(100,true), Default(None) */
    val metagroupname: Rep[Option[String]] = column[Option[String]]("metaGroupName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column iconID SqlType(INT), Default(None) */
    val iconid: Rep[Option[Int]] = column[Option[Int]]("iconID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Invmetagroups */
  lazy val Invmetagroups = new TableQuery(tag => new Invmetagroups(tag))

  /** Entity class storing rows of table Invmetatypes
   *  @param typeid Database column typeID SqlType(INT), PrimaryKey
   *  @param parenttypeid Database column parentTypeID SqlType(INT), Default(None)
   *  @param metagroupid Database column metaGroupID SqlType(SMALLINT), Default(None) */
  case class InvmetatypesRow(typeid: Int, parenttypeid: Option[Int] = None, metagroupid: Option[Short] = None)
  /** GetResult implicit for fetching InvmetatypesRow objects using plain SQL queries */
  implicit def GetResultInvmetatypesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[Short]]): GR[InvmetatypesRow] = GR{
    prs => import prs._
    InvmetatypesRow.tupled((<<[Int], <<?[Int], <<?[Short]))
  }
  /** Table description of table invMetaTypes. Objects of this class serve as prototypes for rows in queries. */
  class Invmetatypes(_tableTag: Tag) extends Table[InvmetatypesRow](_tableTag, "invMetaTypes") {
    def * = (typeid, parenttypeid, metagroupid) <> (InvmetatypesRow.tupled, InvmetatypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), parenttypeid, metagroupid).shaped.<>({r=>import r._; _1.map(_=> InvmetatypesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column typeID SqlType(INT), PrimaryKey */
    val typeid: Rep[Int] = column[Int]("typeID", O.PrimaryKey)
    /** Database column parentTypeID SqlType(INT), Default(None) */
    val parenttypeid: Rep[Option[Int]] = column[Option[Int]]("parentTypeID", O.Default(None))
    /** Database column metaGroupID SqlType(SMALLINT), Default(None) */
    val metagroupid: Rep[Option[Short]] = column[Option[Short]]("metaGroupID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Invmetatypes */
  lazy val Invmetatypes = new TableQuery(tag => new Invmetatypes(tag))

  /** Entity class storing rows of table Invnames
   *  @param itemid Database column itemID SqlType(BIGINT), PrimaryKey
   *  @param itemname Database column itemName SqlType(VARCHAR), Length(200,true) */
  case class InvnamesRow(itemid: Long, itemname: String)
  /** GetResult implicit for fetching InvnamesRow objects using plain SQL queries */
  implicit def GetResultInvnamesRow(implicit e0: GR[Long], e1: GR[String]): GR[InvnamesRow] = GR{
    prs => import prs._
    InvnamesRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table invNames. Objects of this class serve as prototypes for rows in queries. */
  class Invnames(_tableTag: Tag) extends Table[InvnamesRow](_tableTag, "invNames") {
    def * = (itemid, itemname) <> (InvnamesRow.tupled, InvnamesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(itemid), Rep.Some(itemname)).shaped.<>({r=>import r._; _1.map(_=> InvnamesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column itemID SqlType(BIGINT), PrimaryKey */
    val itemid: Rep[Long] = column[Long]("itemID", O.PrimaryKey)
    /** Database column itemName SqlType(VARCHAR), Length(200,true) */
    val itemname: Rep[String] = column[String]("itemName", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Invnames */
  lazy val Invnames = new TableQuery(tag => new Invnames(tag))

  /** Entity class storing rows of table Invpositions
   *  @param itemid Database column itemID SqlType(BIGINT), PrimaryKey
   *  @param x Database column x SqlType(DOUBLE), Default(0.0)
   *  @param y Database column y SqlType(DOUBLE), Default(0.0)
   *  @param z Database column z SqlType(DOUBLE), Default(0.0)
   *  @param yaw Database column yaw SqlType(FLOAT), Default(None)
   *  @param pitch Database column pitch SqlType(FLOAT), Default(None)
   *  @param roll Database column roll SqlType(FLOAT), Default(None) */
  case class InvpositionsRow(itemid: Long, x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, yaw: Option[Float] = None, pitch: Option[Float] = None, roll: Option[Float] = None)
  /** GetResult implicit for fetching InvpositionsRow objects using plain SQL queries */
  implicit def GetResultInvpositionsRow(implicit e0: GR[Long], e1: GR[Double], e2: GR[Option[Float]]): GR[InvpositionsRow] = GR{
    prs => import prs._
    InvpositionsRow.tupled((<<[Long], <<[Double], <<[Double], <<[Double], <<?[Float], <<?[Float], <<?[Float]))
  }
  /** Table description of table invPositions. Objects of this class serve as prototypes for rows in queries. */
  class Invpositions(_tableTag: Tag) extends Table[InvpositionsRow](_tableTag, "invPositions") {
    def * = (itemid, x, y, z, yaw, pitch, roll) <> (InvpositionsRow.tupled, InvpositionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(itemid), Rep.Some(x), Rep.Some(y), Rep.Some(z), yaw, pitch, roll).shaped.<>({r=>import r._; _1.map(_=> InvpositionsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column itemID SqlType(BIGINT), PrimaryKey */
    val itemid: Rep[Long] = column[Long]("itemID", O.PrimaryKey)
    /** Database column x SqlType(DOUBLE), Default(0.0) */
    val x: Rep[Double] = column[Double]("x", O.Default(0.0))
    /** Database column y SqlType(DOUBLE), Default(0.0) */
    val y: Rep[Double] = column[Double]("y", O.Default(0.0))
    /** Database column z SqlType(DOUBLE), Default(0.0) */
    val z: Rep[Double] = column[Double]("z", O.Default(0.0))
    /** Database column yaw SqlType(FLOAT), Default(None) */
    val yaw: Rep[Option[Float]] = column[Option[Float]]("yaw", O.Default(None))
    /** Database column pitch SqlType(FLOAT), Default(None) */
    val pitch: Rep[Option[Float]] = column[Option[Float]]("pitch", O.Default(None))
    /** Database column roll SqlType(FLOAT), Default(None) */
    val roll: Rep[Option[Float]] = column[Option[Float]]("roll", O.Default(None))
  }
  /** Collection-like TableQuery object for table Invpositions */
  lazy val Invpositions = new TableQuery(tag => new Invpositions(tag))

  /** Entity class storing rows of table Invtraits
   *  @param traitid Database column traitID SqlType(INT), AutoInc, PrimaryKey
   *  @param typeid Database column typeID SqlType(INT), Default(None)
   *  @param skillid Database column skillID SqlType(INT), Default(None)
   *  @param bonus Database column bonus SqlType(DOUBLE), Default(None)
   *  @param bonustext Database column bonusText SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param unitid Database column unitID SqlType(INT), Default(None) */
  case class InvtraitsRow(traitid: Int, typeid: Option[Int] = None, skillid: Option[Int] = None, bonus: Option[Double] = None, bonustext: Option[String] = None, unitid: Option[Int] = None)
  /** GetResult implicit for fetching InvtraitsRow objects using plain SQL queries */
  implicit def GetResultInvtraitsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[Double]], e3: GR[Option[String]]): GR[InvtraitsRow] = GR{
    prs => import prs._
    InvtraitsRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[Double], <<?[String], <<?[Int]))
  }
  /** Table description of table invTraits. Objects of this class serve as prototypes for rows in queries. */
  class Invtraits(_tableTag: Tag) extends Table[InvtraitsRow](_tableTag, "invTraits") {
    def * = (traitid, typeid, skillid, bonus, bonustext, unitid) <> (InvtraitsRow.tupled, InvtraitsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(traitid), typeid, skillid, bonus, bonustext, unitid).shaped.<>({r=>import r._; _1.map(_=> InvtraitsRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column traitID SqlType(INT), AutoInc, PrimaryKey */
    val traitid: Rep[Int] = column[Int]("traitID", O.AutoInc, O.PrimaryKey)
    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))
    /** Database column skillID SqlType(INT), Default(None) */
    val skillid: Rep[Option[Int]] = column[Option[Int]]("skillID", O.Default(None))
    /** Database column bonus SqlType(DOUBLE), Default(None) */
    val bonus: Rep[Option[Double]] = column[Option[Double]]("bonus", O.Default(None))
    /** Database column bonusText SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val bonustext: Rep[Option[String]] = column[Option[String]]("bonusText", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column unitID SqlType(INT), Default(None) */
    val unitid: Rep[Option[Int]] = column[Option[Int]]("unitID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Invtraits */
  lazy val Invtraits = new TableQuery(tag => new Invtraits(tag))

  /** Entity class storing rows of table Invtypematerials
   *  @param typeid Database column typeID SqlType(INT)
   *  @param materialtypeid Database column materialTypeID SqlType(INT)
   *  @param quantity Database column quantity SqlType(INT), Default(0) */
  case class InvtypematerialsRow(typeid: Int, materialtypeid: Int, quantity: Int = 0)
  /** GetResult implicit for fetching InvtypematerialsRow objects using plain SQL queries */
  implicit def GetResultInvtypematerialsRow(implicit e0: GR[Int]): GR[InvtypematerialsRow] = GR{
    prs => import prs._
    InvtypematerialsRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table invTypeMaterials. Objects of this class serve as prototypes for rows in queries. */
  class Invtypematerials(_tableTag: Tag) extends Table[InvtypematerialsRow](_tableTag, "invTypeMaterials") {
    def * = (typeid, materialtypeid, quantity) <> (InvtypematerialsRow.tupled, InvtypematerialsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), Rep.Some(materialtypeid), Rep.Some(quantity)).shaped.<>({r=>import r._; _1.map(_=> InvtypematerialsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column materialTypeID SqlType(INT) */
    val materialtypeid: Rep[Int] = column[Int]("materialTypeID")
    /** Database column quantity SqlType(INT), Default(0) */
    val quantity: Rep[Int] = column[Int]("quantity", O.Default(0))

    /** Primary key of Invtypematerials (database name invTypeMaterials_PK) */
    val pk = primaryKey("invTypeMaterials_PK", (typeid, materialtypeid))
  }
  /** Collection-like TableQuery object for table Invtypematerials */
  lazy val Invtypematerials = new TableQuery(tag => new Invtypematerials(tag))

  /** Entity class storing rows of table Invtypereactions
   *  @param reactiontypeid Database column reactionTypeID SqlType(INT)
   *  @param input Database column input SqlType(BIT)
   *  @param typeid Database column typeID SqlType(INT)
   *  @param quantity Database column quantity SqlType(SMALLINT), Default(None) */
  case class InvtypereactionsRow(reactiontypeid: Int, input: Boolean, typeid: Int, quantity: Option[Short] = None)
  /** GetResult implicit for fetching InvtypereactionsRow objects using plain SQL queries */
  implicit def GetResultInvtypereactionsRow(implicit e0: GR[Int], e1: GR[Boolean], e2: GR[Option[Short]]): GR[InvtypereactionsRow] = GR{
    prs => import prs._
    InvtypereactionsRow.tupled((<<[Int], <<[Boolean], <<[Int], <<?[Short]))
  }
  /** Table description of table invTypeReactions. Objects of this class serve as prototypes for rows in queries. */
  class Invtypereactions(_tableTag: Tag) extends Table[InvtypereactionsRow](_tableTag, "invTypeReactions") {
    def * = (reactiontypeid, input, typeid, quantity) <> (InvtypereactionsRow.tupled, InvtypereactionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(reactiontypeid), Rep.Some(input), Rep.Some(typeid), quantity).shaped.<>({r=>import r._; _1.map(_=> InvtypereactionsRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column reactionTypeID SqlType(INT) */
    val reactiontypeid: Rep[Int] = column[Int]("reactionTypeID")
    /** Database column input SqlType(BIT) */
    val input: Rep[Boolean] = column[Boolean]("input")
    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column quantity SqlType(SMALLINT), Default(None) */
    val quantity: Rep[Option[Short]] = column[Option[Short]]("quantity", O.Default(None))

    /** Primary key of Invtypereactions (database name invTypeReactions_PK) */
    val pk = primaryKey("invTypeReactions_PK", (reactiontypeid, input, typeid))
  }
  /** Collection-like TableQuery object for table Invtypereactions */
  lazy val Invtypereactions = new TableQuery(tag => new Invtypereactions(tag))

  /** Entity class storing rows of table Invtypes
   *  @param typeid Database column typeID SqlType(INT), PrimaryKey
   *  @param groupid Database column groupID SqlType(INT), Default(None)
   *  @param typename Database column typeName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param mass Database column mass SqlType(DOUBLE), Default(None)
   *  @param volume Database column volume SqlType(DOUBLE), Default(None)
   *  @param capacity Database column capacity SqlType(DOUBLE), Default(None)
   *  @param portionsize Database column portionSize SqlType(INT), Default(None)
   *  @param raceid Database column raceID SqlType(SMALLINT), Default(None)
   *  @param baseprice Database column basePrice SqlType(DECIMAL), Default(None)
   *  @param published Database column published SqlType(BIT), Default(None)
   *  @param marketgroupid Database column marketGroupID SqlType(BIGINT), Default(None)
   *  @param iconid Database column iconID SqlType(BIGINT), Default(None)
   *  @param soundid Database column soundID SqlType(BIGINT), Default(None) */
  case class InvtypesRow(typeid: Int, groupid: Option[Int] = None, typename: Option[String] = None, description: Option[String] = None, mass: Option[Double] = None, volume: Option[Double] = None, capacity: Option[Double] = None, portionsize: Option[Int] = None, raceid: Option[Short] = None, baseprice: Option[scala.math.BigDecimal] = None, published: Option[Boolean] = None, marketgroupid: Option[Long] = None, iconid: Option[Long] = None, soundid: Option[Long] = None)
  /** GetResult implicit for fetching InvtypesRow objects using plain SQL queries */
  implicit def GetResultInvtypesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Double]], e4: GR[Option[Short]], e5: GR[Option[scala.math.BigDecimal]], e6: GR[Option[Boolean]], e7: GR[Option[Long]]): GR[InvtypesRow] = GR{
    prs => import prs._
    InvtypesRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Int], <<?[Short], <<?[scala.math.BigDecimal], <<?[Boolean], <<?[Long], <<?[Long], <<?[Long]))
  }
  /** Table description of table invTypes. Objects of this class serve as prototypes for rows in queries. */
  class Invtypes(_tableTag: Tag) extends Table[InvtypesRow](_tableTag, "invTypes") {
    def * = (typeid, groupid, typename, description, mass, volume, capacity, portionsize, raceid, baseprice, published, marketgroupid, iconid, soundid) <> (InvtypesRow.tupled, InvtypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(typeid), groupid, typename, description, mass, volume, capacity, portionsize, raceid, baseprice, published, marketgroupid, iconid, soundid).shaped.<>({r=>import r._; _1.map(_=> InvtypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column typeID SqlType(INT), PrimaryKey */
    val typeid: Rep[Int] = column[Int]("typeID", O.PrimaryKey)
    /** Database column groupID SqlType(INT), Default(None) */
    val groupid: Rep[Option[Int]] = column[Option[Int]]("groupID", O.Default(None))
    /** Database column typeName SqlType(VARCHAR), Length(100,true), Default(None) */
    val typename: Rep[Option[String]] = column[Option[String]]("typeName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column mass SqlType(DOUBLE), Default(None) */
    val mass: Rep[Option[Double]] = column[Option[Double]]("mass", O.Default(None))
    /** Database column volume SqlType(DOUBLE), Default(None) */
    val volume: Rep[Option[Double]] = column[Option[Double]]("volume", O.Default(None))
    /** Database column capacity SqlType(DOUBLE), Default(None) */
    val capacity: Rep[Option[Double]] = column[Option[Double]]("capacity", O.Default(None))
    /** Database column portionSize SqlType(INT), Default(None) */
    val portionsize: Rep[Option[Int]] = column[Option[Int]]("portionSize", O.Default(None))
    /** Database column raceID SqlType(SMALLINT), Default(None) */
    val raceid: Rep[Option[Short]] = column[Option[Short]]("raceID", O.Default(None))
    /** Database column basePrice SqlType(DECIMAL), Default(None) */
    val baseprice: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("basePrice", O.Default(None))
    /** Database column published SqlType(BIT), Default(None) */
    val published: Rep[Option[Boolean]] = column[Option[Boolean]]("published", O.Default(None))
    /** Database column marketGroupID SqlType(BIGINT), Default(None) */
    val marketgroupid: Rep[Option[Long]] = column[Option[Long]]("marketGroupID", O.Default(None))
    /** Database column iconID SqlType(BIGINT), Default(None) */
    val iconid: Rep[Option[Long]] = column[Option[Long]]("iconID", O.Default(None))
    /** Database column soundID SqlType(BIGINT), Default(None) */
    val soundid: Rep[Option[Long]] = column[Option[Long]]("soundID", O.Default(None))

    /** Index over (groupid) (database name invTypes_groupid) */
    val index1 = index("invTypes_groupid", groupid)
  }
  /** Collection-like TableQuery object for table Invtypes */
  lazy val Invtypes = new TableQuery(tag => new Invtypes(tag))

  /** Entity class storing rows of table Invuniquenames
   *  @param itemid Database column itemID SqlType(INT), PrimaryKey
   *  @param itemname Database column itemName SqlType(VARCHAR), Length(200,true)
   *  @param groupid Database column groupID SqlType(INT), Default(None) */
  case class InvuniquenamesRow(itemid: Int, itemname: String, groupid: Option[Int] = None)
  /** GetResult implicit for fetching InvuniquenamesRow objects using plain SQL queries */
  implicit def GetResultInvuniquenamesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]]): GR[InvuniquenamesRow] = GR{
    prs => import prs._
    InvuniquenamesRow.tupled((<<[Int], <<[String], <<?[Int]))
  }
  /** Table description of table invUniqueNames. Objects of this class serve as prototypes for rows in queries. */
  class Invuniquenames(_tableTag: Tag) extends Table[InvuniquenamesRow](_tableTag, "invUniqueNames") {
    def * = (itemid, itemname, groupid) <> (InvuniquenamesRow.tupled, InvuniquenamesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(itemid), Rep.Some(itemname), groupid).shaped.<>({r=>import r._; _1.map(_=> InvuniquenamesRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column itemID SqlType(INT), PrimaryKey */
    val itemid: Rep[Int] = column[Int]("itemID", O.PrimaryKey)
    /** Database column itemName SqlType(VARCHAR), Length(200,true) */
    val itemname: Rep[String] = column[String]("itemName", O.Length(200,varying=true))
    /** Database column groupID SqlType(INT), Default(None) */
    val groupid: Rep[Option[Int]] = column[Option[Int]]("groupID", O.Default(None))

    /** Index over (groupid,itemname) (database name invUniqueNames_IX_GroupName) */
    val index1 = index("invUniqueNames_IX_GroupName", (groupid, itemname))
    /** Uniqueness Index over (itemname) (database name invUniqueNames_UQ) */
    val index2 = index("invUniqueNames_UQ", itemname, unique=true)
  }
  /** Collection-like TableQuery object for table Invuniquenames */
  lazy val Invuniquenames = new TableQuery(tag => new Invuniquenames(tag))

  /** Entity class storing rows of table Mapcelestialstatistics
   *  @param celestialid Database column celestialID SqlType(INT), AutoInc, PrimaryKey
   *  @param temperature Database column temperature SqlType(DOUBLE), Default(None)
   *  @param spectralclass Database column spectralClass SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param luminosity Database column luminosity SqlType(DOUBLE), Default(None)
   *  @param age Database column age SqlType(DOUBLE), Default(None)
   *  @param life Database column life SqlType(DOUBLE), Default(None)
   *  @param orbitradius Database column orbitRadius SqlType(DOUBLE), Default(None)
   *  @param eccentricity Database column eccentricity SqlType(DOUBLE), Default(None)
   *  @param massdust Database column massDust SqlType(DOUBLE), Default(None)
   *  @param massgas Database column massGas SqlType(DOUBLE), Default(None)
   *  @param fragmented Database column fragmented SqlType(INT), Default(None)
   *  @param density Database column density SqlType(DOUBLE), Default(None)
   *  @param surfacegravity Database column surfaceGravity SqlType(DOUBLE), Default(None)
   *  @param escapevelocity Database column escapeVelocity SqlType(DOUBLE), Default(None)
   *  @param orbitperiod Database column orbitPeriod SqlType(DOUBLE), Default(None)
   *  @param rotationrate Database column rotationRate SqlType(DOUBLE), Default(None)
   *  @param locked Database column locked SqlType(INT), Default(None)
   *  @param pressure Database column pressure SqlType(BIGINT), Default(None)
   *  @param radius Database column radius SqlType(BIGINT), Default(None)
   *  @param mass Database column mass SqlType(INT), Default(None) */
  case class MapcelestialstatisticsRow(celestialid: Int, temperature: Option[Double] = None, spectralclass: Option[String] = None, luminosity: Option[Double] = None, age: Option[Double] = None, life: Option[Double] = None, orbitradius: Option[Double] = None, eccentricity: Option[Double] = None, massdust: Option[Double] = None, massgas: Option[Double] = None, fragmented: Option[Int] = None, density: Option[Double] = None, surfacegravity: Option[Double] = None, escapevelocity: Option[Double] = None, orbitperiod: Option[Double] = None, rotationrate: Option[Double] = None, locked: Option[Int] = None, pressure: Option[Long] = None, radius: Option[Long] = None, mass: Option[Int] = None)
  /** GetResult implicit for fetching MapcelestialstatisticsRow objects using plain SQL queries */
  implicit def GetResultMapcelestialstatisticsRow(implicit e0: GR[Int], e1: GR[Option[Double]], e2: GR[Option[String]], e3: GR[Option[Int]], e4: GR[Option[Long]]): GR[MapcelestialstatisticsRow] = GR{
    prs => import prs._
    MapcelestialstatisticsRow.tupled((<<[Int], <<?[Double], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Int], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Int], <<?[Long], <<?[Long], <<?[Int]))
  }
  /** Table description of table mapCelestialStatistics. Objects of this class serve as prototypes for rows in queries. */
  class Mapcelestialstatistics(_tableTag: Tag) extends Table[MapcelestialstatisticsRow](_tableTag, "mapCelestialStatistics") {
    def * = (celestialid, temperature, spectralclass, luminosity, age, life, orbitradius, eccentricity, massdust, massgas, fragmented, density, surfacegravity, escapevelocity, orbitperiod, rotationrate, locked, pressure, radius, mass) <> (MapcelestialstatisticsRow.tupled, MapcelestialstatisticsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(celestialid), temperature, spectralclass, luminosity, age, life, orbitradius, eccentricity, massdust, massgas, fragmented, density, surfacegravity, escapevelocity, orbitperiod, rotationrate, locked, pressure, radius, mass).shaped.<>({r=>import r._; _1.map(_=> MapcelestialstatisticsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column celestialID SqlType(INT), AutoInc, PrimaryKey */
    val celestialid: Rep[Int] = column[Int]("celestialID", O.AutoInc, O.PrimaryKey)
    /** Database column temperature SqlType(DOUBLE), Default(None) */
    val temperature: Rep[Option[Double]] = column[Option[Double]]("temperature", O.Default(None))
    /** Database column spectralClass SqlType(VARCHAR), Length(10,true), Default(None) */
    val spectralclass: Rep[Option[String]] = column[Option[String]]("spectralClass", O.Length(10,varying=true), O.Default(None))
    /** Database column luminosity SqlType(DOUBLE), Default(None) */
    val luminosity: Rep[Option[Double]] = column[Option[Double]]("luminosity", O.Default(None))
    /** Database column age SqlType(DOUBLE), Default(None) */
    val age: Rep[Option[Double]] = column[Option[Double]]("age", O.Default(None))
    /** Database column life SqlType(DOUBLE), Default(None) */
    val life: Rep[Option[Double]] = column[Option[Double]]("life", O.Default(None))
    /** Database column orbitRadius SqlType(DOUBLE), Default(None) */
    val orbitradius: Rep[Option[Double]] = column[Option[Double]]("orbitRadius", O.Default(None))
    /** Database column eccentricity SqlType(DOUBLE), Default(None) */
    val eccentricity: Rep[Option[Double]] = column[Option[Double]]("eccentricity", O.Default(None))
    /** Database column massDust SqlType(DOUBLE), Default(None) */
    val massdust: Rep[Option[Double]] = column[Option[Double]]("massDust", O.Default(None))
    /** Database column massGas SqlType(DOUBLE), Default(None) */
    val massgas: Rep[Option[Double]] = column[Option[Double]]("massGas", O.Default(None))
    /** Database column fragmented SqlType(INT), Default(None) */
    val fragmented: Rep[Option[Int]] = column[Option[Int]]("fragmented", O.Default(None))
    /** Database column density SqlType(DOUBLE), Default(None) */
    val density: Rep[Option[Double]] = column[Option[Double]]("density", O.Default(None))
    /** Database column surfaceGravity SqlType(DOUBLE), Default(None) */
    val surfacegravity: Rep[Option[Double]] = column[Option[Double]]("surfaceGravity", O.Default(None))
    /** Database column escapeVelocity SqlType(DOUBLE), Default(None) */
    val escapevelocity: Rep[Option[Double]] = column[Option[Double]]("escapeVelocity", O.Default(None))
    /** Database column orbitPeriod SqlType(DOUBLE), Default(None) */
    val orbitperiod: Rep[Option[Double]] = column[Option[Double]]("orbitPeriod", O.Default(None))
    /** Database column rotationRate SqlType(DOUBLE), Default(None) */
    val rotationrate: Rep[Option[Double]] = column[Option[Double]]("rotationRate", O.Default(None))
    /** Database column locked SqlType(INT), Default(None) */
    val locked: Rep[Option[Int]] = column[Option[Int]]("locked", O.Default(None))
    /** Database column pressure SqlType(BIGINT), Default(None) */
    val pressure: Rep[Option[Long]] = column[Option[Long]]("pressure", O.Default(None))
    /** Database column radius SqlType(BIGINT), Default(None) */
    val radius: Rep[Option[Long]] = column[Option[Long]]("radius", O.Default(None))
    /** Database column mass SqlType(INT), Default(None) */
    val mass: Rep[Option[Int]] = column[Option[Int]]("mass", O.Default(None))
  }
  /** Collection-like TableQuery object for table Mapcelestialstatistics */
  lazy val Mapcelestialstatistics = new TableQuery(tag => new Mapcelestialstatistics(tag))

  /** Entity class storing rows of table Mapconstellationjumps
   *  @param fromregionid Database column fromRegionID SqlType(BIGINT), Default(None)
   *  @param fromconstellationid Database column fromConstellationID SqlType(BIGINT)
   *  @param toconstellationid Database column toConstellationID SqlType(BIGINT)
   *  @param toregionid Database column toRegionID SqlType(BIGINT), Default(None) */
  case class MapconstellationjumpsRow(fromregionid: Option[Long] = None, fromconstellationid: Long, toconstellationid: Long, toregionid: Option[Long] = None)
  /** GetResult implicit for fetching MapconstellationjumpsRow objects using plain SQL queries */
  implicit def GetResultMapconstellationjumpsRow(implicit e0: GR[Option[Long]], e1: GR[Long]): GR[MapconstellationjumpsRow] = GR{
    prs => import prs._
    MapconstellationjumpsRow.tupled((<<?[Long], <<[Long], <<[Long], <<?[Long]))
  }
  /** Table description of table mapConstellationJumps. Objects of this class serve as prototypes for rows in queries. */
  class Mapconstellationjumps(_tableTag: Tag) extends Table[MapconstellationjumpsRow](_tableTag, "mapConstellationJumps") {
    def * = (fromregionid, fromconstellationid, toconstellationid, toregionid) <> (MapconstellationjumpsRow.tupled, MapconstellationjumpsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (fromregionid, Rep.Some(fromconstellationid), Rep.Some(toconstellationid), toregionid).shaped.<>({r=>import r._; _2.map(_=> MapconstellationjumpsRow.tupled((_1, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fromRegionID SqlType(BIGINT), Default(None) */
    val fromregionid: Rep[Option[Long]] = column[Option[Long]]("fromRegionID", O.Default(None))
    /** Database column fromConstellationID SqlType(BIGINT) */
    val fromconstellationid: Rep[Long] = column[Long]("fromConstellationID")
    /** Database column toConstellationID SqlType(BIGINT) */
    val toconstellationid: Rep[Long] = column[Long]("toConstellationID")
    /** Database column toRegionID SqlType(BIGINT), Default(None) */
    val toregionid: Rep[Option[Long]] = column[Option[Long]]("toRegionID", O.Default(None))

    /** Primary key of Mapconstellationjumps (database name mapConstellationJumps_PK) */
    val pk = primaryKey("mapConstellationJumps_PK", (fromconstellationid, toconstellationid))
  }
  /** Collection-like TableQuery object for table Mapconstellationjumps */
  lazy val Mapconstellationjumps = new TableQuery(tag => new Mapconstellationjumps(tag))

  /** Entity class storing rows of table Mapconstellations
   *  @param regionid Database column regionID SqlType(INT), Default(None)
   *  @param constellationid Database column constellationID SqlType(INT), AutoInc, PrimaryKey
   *  @param constellationname Database column constellationName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param x Database column x SqlType(DOUBLE), Default(None)
   *  @param y Database column y SqlType(DOUBLE), Default(None)
   *  @param z Database column z SqlType(DOUBLE), Default(None)
   *  @param xmin Database column xMin SqlType(DOUBLE), Default(None)
   *  @param xmax Database column xMax SqlType(DOUBLE), Default(None)
   *  @param ymin Database column yMin SqlType(DOUBLE), Default(None)
   *  @param ymax Database column yMax SqlType(DOUBLE), Default(None)
   *  @param zmin Database column zMin SqlType(DOUBLE), Default(None)
   *  @param zmax Database column zMax SqlType(DOUBLE), Default(None)
   *  @param factionid Database column factionID SqlType(INT), Default(None)
   *  @param radius Database column radius SqlType(DOUBLE), Default(None) */
  case class MapconstellationsRow(regionid: Option[Int] = None, constellationid: Int, constellationname: Option[String] = None, x: Option[Double] = None, y: Option[Double] = None, z: Option[Double] = None, xmin: Option[Double] = None, xmax: Option[Double] = None, ymin: Option[Double] = None, ymax: Option[Double] = None, zmin: Option[Double] = None, zmax: Option[Double] = None, factionid: Option[Int] = None, radius: Option[Double] = None)
  /** GetResult implicit for fetching MapconstellationsRow objects using plain SQL queries */
  implicit def GetResultMapconstellationsRow(implicit e0: GR[Option[Int]], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Double]]): GR[MapconstellationsRow] = GR{
    prs => import prs._
    MapconstellationsRow.tupled((<<?[Int], <<[Int], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Int], <<?[Double]))
  }
  /** Table description of table mapConstellations. Objects of this class serve as prototypes for rows in queries. */
  class Mapconstellations(_tableTag: Tag) extends Table[MapconstellationsRow](_tableTag, "mapConstellations") {
    def * = (regionid, constellationid, constellationname, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, factionid, radius) <> (MapconstellationsRow.tupled, MapconstellationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (regionid, Rep.Some(constellationid), constellationname, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, factionid, radius).shaped.<>({r=>import r._; _2.map(_=> MapconstellationsRow.tupled((_1, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column regionID SqlType(INT), Default(None) */
    val regionid: Rep[Option[Int]] = column[Option[Int]]("regionID", O.Default(None))
    /** Database column constellationID SqlType(INT), AutoInc, PrimaryKey */
    val constellationid: Rep[Int] = column[Int]("constellationID", O.AutoInc, O.PrimaryKey)
    /** Database column constellationName SqlType(VARCHAR), Length(100,true), Default(None) */
    val constellationname: Rep[Option[String]] = column[Option[String]]("constellationName", O.Length(100,varying=true), O.Default(None))
    /** Database column x SqlType(DOUBLE), Default(None) */
    val x: Rep[Option[Double]] = column[Option[Double]]("x", O.Default(None))
    /** Database column y SqlType(DOUBLE), Default(None) */
    val y: Rep[Option[Double]] = column[Option[Double]]("y", O.Default(None))
    /** Database column z SqlType(DOUBLE), Default(None) */
    val z: Rep[Option[Double]] = column[Option[Double]]("z", O.Default(None))
    /** Database column xMin SqlType(DOUBLE), Default(None) */
    val xmin: Rep[Option[Double]] = column[Option[Double]]("xMin", O.Default(None))
    /** Database column xMax SqlType(DOUBLE), Default(None) */
    val xmax: Rep[Option[Double]] = column[Option[Double]]("xMax", O.Default(None))
    /** Database column yMin SqlType(DOUBLE), Default(None) */
    val ymin: Rep[Option[Double]] = column[Option[Double]]("yMin", O.Default(None))
    /** Database column yMax SqlType(DOUBLE), Default(None) */
    val ymax: Rep[Option[Double]] = column[Option[Double]]("yMax", O.Default(None))
    /** Database column zMin SqlType(DOUBLE), Default(None) */
    val zmin: Rep[Option[Double]] = column[Option[Double]]("zMin", O.Default(None))
    /** Database column zMax SqlType(DOUBLE), Default(None) */
    val zmax: Rep[Option[Double]] = column[Option[Double]]("zMax", O.Default(None))
    /** Database column factionID SqlType(INT), Default(None) */
    val factionid: Rep[Option[Int]] = column[Option[Int]]("factionID", O.Default(None))
    /** Database column radius SqlType(DOUBLE), Default(None) */
    val radius: Rep[Option[Double]] = column[Option[Double]]("radius", O.Default(None))

    /** Index over (regionid) (database name mapConstellations_IX_region) */
    val index1 = index("mapConstellations_IX_region", regionid)
  }
  /** Collection-like TableQuery object for table Mapconstellations */
  lazy val Mapconstellations = new TableQuery(tag => new Mapconstellations(tag))

  /** Entity class storing rows of table Mapdenormalize
   *  @param itemid Database column itemID SqlType(INT), AutoInc, PrimaryKey
   *  @param typeid Database column typeID SqlType(INT), Default(None)
   *  @param groupid Database column groupID SqlType(INT), Default(None)
   *  @param solarsystemid Database column solarSystemID SqlType(INT), Default(None)
   *  @param constellationid Database column constellationID SqlType(INT), Default(None)
   *  @param regionid Database column regionID SqlType(INT), Default(None)
   *  @param orbitid Database column orbitID SqlType(INT), Default(None)
   *  @param x Database column x SqlType(DOUBLE), Default(None)
   *  @param y Database column y SqlType(DOUBLE), Default(None)
   *  @param z Database column z SqlType(DOUBLE), Default(None)
   *  @param radius Database column radius SqlType(DOUBLE), Default(None)
   *  @param itemname Database column itemName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param security Database column security SqlType(DOUBLE), Default(None)
   *  @param celestialindex Database column celestialIndex SqlType(INT), Default(None)
   *  @param orbitindex Database column orbitIndex SqlType(INT), Default(None) */
  case class MapdenormalizeRow(itemid: Int, typeid: Option[Int] = None, groupid: Option[Int] = None, solarsystemid: Option[Int] = None, constellationid: Option[Int] = None, regionid: Option[Int] = None, orbitid: Option[Int] = None, x: Option[Double] = None, y: Option[Double] = None, z: Option[Double] = None, radius: Option[Double] = None, itemname: Option[String] = None, security: Option[Double] = None, celestialindex: Option[Int] = None, orbitindex: Option[Int] = None)
  /** GetResult implicit for fetching MapdenormalizeRow objects using plain SQL queries */
  implicit def GetResultMapdenormalizeRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[Double]], e3: GR[Option[String]]): GR[MapdenormalizeRow] = GR{
    prs => import prs._
    MapdenormalizeRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[String], <<?[Double], <<?[Int], <<?[Int]))
  }
  /** Table description of table mapDenormalize. Objects of this class serve as prototypes for rows in queries. */
  class Mapdenormalize(_tableTag: Tag) extends Table[MapdenormalizeRow](_tableTag, "mapDenormalize") {
    def * = (itemid, typeid, groupid, solarsystemid, constellationid, regionid, orbitid, x, y, z, radius, itemname, security, celestialindex, orbitindex) <> (MapdenormalizeRow.tupled, MapdenormalizeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(itemid), typeid, groupid, solarsystemid, constellationid, regionid, orbitid, x, y, z, radius, itemname, security, celestialindex, orbitindex).shaped.<>({r=>import r._; _1.map(_=> MapdenormalizeRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column itemID SqlType(INT), AutoInc, PrimaryKey */
    val itemid: Rep[Int] = column[Int]("itemID", O.AutoInc, O.PrimaryKey)
    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))
    /** Database column groupID SqlType(INT), Default(None) */
    val groupid: Rep[Option[Int]] = column[Option[Int]]("groupID", O.Default(None))
    /** Database column solarSystemID SqlType(INT), Default(None) */
    val solarsystemid: Rep[Option[Int]] = column[Option[Int]]("solarSystemID", O.Default(None))
    /** Database column constellationID SqlType(INT), Default(None) */
    val constellationid: Rep[Option[Int]] = column[Option[Int]]("constellationID", O.Default(None))
    /** Database column regionID SqlType(INT), Default(None) */
    val regionid: Rep[Option[Int]] = column[Option[Int]]("regionID", O.Default(None))
    /** Database column orbitID SqlType(INT), Default(None) */
    val orbitid: Rep[Option[Int]] = column[Option[Int]]("orbitID", O.Default(None))
    /** Database column x SqlType(DOUBLE), Default(None) */
    val x: Rep[Option[Double]] = column[Option[Double]]("x", O.Default(None))
    /** Database column y SqlType(DOUBLE), Default(None) */
    val y: Rep[Option[Double]] = column[Option[Double]]("y", O.Default(None))
    /** Database column z SqlType(DOUBLE), Default(None) */
    val z: Rep[Option[Double]] = column[Option[Double]]("z", O.Default(None))
    /** Database column radius SqlType(DOUBLE), Default(None) */
    val radius: Rep[Option[Double]] = column[Option[Double]]("radius", O.Default(None))
    /** Database column itemName SqlType(VARCHAR), Length(100,true), Default(None) */
    val itemname: Rep[Option[String]] = column[Option[String]]("itemName", O.Length(100,varying=true), O.Default(None))
    /** Database column security SqlType(DOUBLE), Default(None) */
    val security: Rep[Option[Double]] = column[Option[Double]]("security", O.Default(None))
    /** Database column celestialIndex SqlType(INT), Default(None) */
    val celestialindex: Rep[Option[Int]] = column[Option[Int]]("celestialIndex", O.Default(None))
    /** Database column orbitIndex SqlType(INT), Default(None) */
    val orbitindex: Rep[Option[Int]] = column[Option[Int]]("orbitIndex", O.Default(None))

    /** Index over (constellationid) (database name mapDenormalize_IX_constellation) */
    val index1 = index("mapDenormalize_IX_constellation", constellationid)
    /** Index over (groupid,constellationid) (database name mapDenormalize_IX_groupConstellation) */
    val index2 = index("mapDenormalize_IX_groupConstellation", (groupid, constellationid))
    /** Index over (groupid,regionid) (database name mapDenormalize_IX_groupRegion) */
    val index3 = index("mapDenormalize_IX_groupRegion", (groupid, regionid))
    /** Index over (groupid,solarsystemid) (database name mapDenormalize_IX_groupSystem) */
    val index4 = index("mapDenormalize_IX_groupSystem", (groupid, solarsystemid))
    /** Index over (orbitid) (database name mapDenormalize_IX_orbit) */
    val index5 = index("mapDenormalize_IX_orbit", orbitid)
    /** Index over (regionid) (database name mapDenormalize_IX_region) */
    val index6 = index("mapDenormalize_IX_region", regionid)
    /** Index over (solarsystemid) (database name mapDenormalize_IX_system) */
    val index7 = index("mapDenormalize_IX_system", solarsystemid)
    /** Index over (solarsystemid,x,y,z,itemname,itemid) (database name mapDenormalize_gis) */
    val index8 = index("mapDenormalize_gis", (solarsystemid, x, y, z, itemname, itemid))
  }
  /** Collection-like TableQuery object for table Mapdenormalize */
  lazy val Mapdenormalize = new TableQuery(tag => new Mapdenormalize(tag))

  /** Entity class storing rows of table Mapjumps
   *  @param stargateid Database column stargateID SqlType(BIGINT), PrimaryKey
   *  @param destinationid Database column destinationID SqlType(BIGINT), Default(None) */
  case class MapjumpsRow(stargateid: Long, destinationid: Option[Long] = None)
  /** GetResult implicit for fetching MapjumpsRow objects using plain SQL queries */
  implicit def GetResultMapjumpsRow(implicit e0: GR[Long], e1: GR[Option[Long]]): GR[MapjumpsRow] = GR{
    prs => import prs._
    MapjumpsRow.tupled((<<[Long], <<?[Long]))
  }
  /** Table description of table mapJumps. Objects of this class serve as prototypes for rows in queries. */
  class Mapjumps(_tableTag: Tag) extends Table[MapjumpsRow](_tableTag, "mapJumps") {
    def * = (stargateid, destinationid) <> (MapjumpsRow.tupled, MapjumpsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(stargateid), destinationid).shaped.<>({r=>import r._; _1.map(_=> MapjumpsRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column stargateID SqlType(BIGINT), PrimaryKey */
    val stargateid: Rep[Long] = column[Long]("stargateID", O.PrimaryKey)
    /** Database column destinationID SqlType(BIGINT), Default(None) */
    val destinationid: Rep[Option[Long]] = column[Option[Long]]("destinationID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Mapjumps */
  lazy val Mapjumps = new TableQuery(tag => new Mapjumps(tag))

  /** Entity class storing rows of table Maplandmarks
   *  @param landmarkid Database column landmarkID SqlType(BIGINT), PrimaryKey
   *  @param landmarkname Database column landmarkName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None)
   *  @param locationid Database column locationID SqlType(BIGINT), Default(None)
   *  @param x Database column x SqlType(DOUBLE), Default(None)
   *  @param y Database column y SqlType(DOUBLE), Default(None)
   *  @param z Database column z SqlType(DOUBLE), Default(None)
   *  @param iconid Database column iconID SqlType(BIGINT), Default(None) */
  case class MaplandmarksRow(landmarkid: Long, landmarkname: Option[String] = None, description: Option[String] = None, locationid: Option[Long] = None, x: Option[Double] = None, y: Option[Double] = None, z: Option[Double] = None, iconid: Option[Long] = None)
  /** GetResult implicit for fetching MaplandmarksRow objects using plain SQL queries */
  implicit def GetResultMaplandmarksRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[Option[Double]]): GR[MaplandmarksRow] = GR{
    prs => import prs._
    MaplandmarksRow.tupled((<<[Long], <<?[String], <<?[String], <<?[Long], <<?[Double], <<?[Double], <<?[Double], <<?[Long]))
  }
  /** Table description of table mapLandmarks. Objects of this class serve as prototypes for rows in queries. */
  class Maplandmarks(_tableTag: Tag) extends Table[MaplandmarksRow](_tableTag, "mapLandmarks") {
    def * = (landmarkid, landmarkname, description, locationid, x, y, z, iconid) <> (MaplandmarksRow.tupled, MaplandmarksRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(landmarkid), landmarkname, description, locationid, x, y, z, iconid).shaped.<>({r=>import r._; _1.map(_=> MaplandmarksRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column landmarkID SqlType(BIGINT), PrimaryKey */
    val landmarkid: Rep[Long] = column[Long]("landmarkID", O.PrimaryKey)
    /** Database column landmarkName SqlType(VARCHAR), Length(100,true), Default(None) */
    val landmarkname: Rep[Option[String]] = column[Option[String]]("landmarkName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(LONGTEXT), Length(2147483647,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column locationID SqlType(BIGINT), Default(None) */
    val locationid: Rep[Option[Long]] = column[Option[Long]]("locationID", O.Default(None))
    /** Database column x SqlType(DOUBLE), Default(None) */
    val x: Rep[Option[Double]] = column[Option[Double]]("x", O.Default(None))
    /** Database column y SqlType(DOUBLE), Default(None) */
    val y: Rep[Option[Double]] = column[Option[Double]]("y", O.Default(None))
    /** Database column z SqlType(DOUBLE), Default(None) */
    val z: Rep[Option[Double]] = column[Option[Double]]("z", O.Default(None))
    /** Database column iconID SqlType(BIGINT), Default(None) */
    val iconid: Rep[Option[Long]] = column[Option[Long]]("iconID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Maplandmarks */
  lazy val Maplandmarks = new TableQuery(tag => new Maplandmarks(tag))

  /** Entity class storing rows of table Maplocationscenes
   *  @param locationid Database column locationID SqlType(INT), AutoInc, PrimaryKey
   *  @param graphicid Database column graphicID SqlType(INT), Default(None) */
  case class MaplocationscenesRow(locationid: Int, graphicid: Option[Int] = None)
  /** GetResult implicit for fetching MaplocationscenesRow objects using plain SQL queries */
  implicit def GetResultMaplocationscenesRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[MaplocationscenesRow] = GR{
    prs => import prs._
    MaplocationscenesRow.tupled((<<[Int], <<?[Int]))
  }
  /** Table description of table mapLocationScenes. Objects of this class serve as prototypes for rows in queries. */
  class Maplocationscenes(_tableTag: Tag) extends Table[MaplocationscenesRow](_tableTag, "mapLocationScenes") {
    def * = (locationid, graphicid) <> (MaplocationscenesRow.tupled, MaplocationscenesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(locationid), graphicid).shaped.<>({r=>import r._; _1.map(_=> MaplocationscenesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column locationID SqlType(INT), AutoInc, PrimaryKey */
    val locationid: Rep[Int] = column[Int]("locationID", O.AutoInc, O.PrimaryKey)
    /** Database column graphicID SqlType(INT), Default(None) */
    val graphicid: Rep[Option[Int]] = column[Option[Int]]("graphicID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Maplocationscenes */
  lazy val Maplocationscenes = new TableQuery(tag => new Maplocationscenes(tag))

  /** Entity class storing rows of table Maplocationwormholeclasses
   *  @param locationid Database column locationID SqlType(INT), AutoInc, PrimaryKey
   *  @param wormholeclassid Database column wormholeClassID SqlType(INT), Default(None) */
  case class MaplocationwormholeclassesRow(locationid: Int, wormholeclassid: Option[Int] = None)
  /** GetResult implicit for fetching MaplocationwormholeclassesRow objects using plain SQL queries */
  implicit def GetResultMaplocationwormholeclassesRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[MaplocationwormholeclassesRow] = GR{
    prs => import prs._
    MaplocationwormholeclassesRow.tupled((<<[Int], <<?[Int]))
  }
  /** Table description of table mapLocationWormholeClasses. Objects of this class serve as prototypes for rows in queries. */
  class Maplocationwormholeclasses(_tableTag: Tag) extends Table[MaplocationwormholeclassesRow](_tableTag, "mapLocationWormholeClasses") {
    def * = (locationid, wormholeclassid) <> (MaplocationwormholeclassesRow.tupled, MaplocationwormholeclassesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(locationid), wormholeclassid).shaped.<>({r=>import r._; _1.map(_=> MaplocationwormholeclassesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column locationID SqlType(INT), AutoInc, PrimaryKey */
    val locationid: Rep[Int] = column[Int]("locationID", O.AutoInc, O.PrimaryKey)
    /** Database column wormholeClassID SqlType(INT), Default(None) */
    val wormholeclassid: Rep[Option[Int]] = column[Option[Int]]("wormholeClassID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Maplocationwormholeclasses */
  lazy val Maplocationwormholeclasses = new TableQuery(tag => new Maplocationwormholeclasses(tag))

  /** Entity class storing rows of table Mapregionjumps
   *  @param fromregionid Database column fromRegionID SqlType(BIGINT)
   *  @param toregionid Database column toRegionID SqlType(BIGINT) */
  case class MapregionjumpsRow(fromregionid: Long, toregionid: Long)
  /** GetResult implicit for fetching MapregionjumpsRow objects using plain SQL queries */
  implicit def GetResultMapregionjumpsRow(implicit e0: GR[Long]): GR[MapregionjumpsRow] = GR{
    prs => import prs._
    MapregionjumpsRow.tupled((<<[Long], <<[Long]))
  }
  /** Table description of table mapRegionJumps. Objects of this class serve as prototypes for rows in queries. */
  class Mapregionjumps(_tableTag: Tag) extends Table[MapregionjumpsRow](_tableTag, "mapRegionJumps") {
    def * = (fromregionid, toregionid) <> (MapregionjumpsRow.tupled, MapregionjumpsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(fromregionid), Rep.Some(toregionid)).shaped.<>({r=>import r._; _1.map(_=> MapregionjumpsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fromRegionID SqlType(BIGINT) */
    val fromregionid: Rep[Long] = column[Long]("fromRegionID")
    /** Database column toRegionID SqlType(BIGINT) */
    val toregionid: Rep[Long] = column[Long]("toRegionID")

    /** Primary key of Mapregionjumps (database name mapRegionJumps_PK) */
    val pk = primaryKey("mapRegionJumps_PK", (fromregionid, toregionid))
  }
  /** Collection-like TableQuery object for table Mapregionjumps */
  lazy val Mapregionjumps = new TableQuery(tag => new Mapregionjumps(tag))

  /** Entity class storing rows of table Mapregions
   *  @param regionid Database column regionID SqlType(INT), AutoInc, PrimaryKey
   *  @param regionname Database column regionName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param x Database column x SqlType(DOUBLE), Default(None)
   *  @param y Database column y SqlType(DOUBLE), Default(None)
   *  @param z Database column z SqlType(DOUBLE), Default(None)
   *  @param xmin Database column xMin SqlType(DOUBLE), Default(None)
   *  @param xmax Database column xMax SqlType(DOUBLE), Default(None)
   *  @param ymin Database column yMin SqlType(DOUBLE), Default(None)
   *  @param ymax Database column yMax SqlType(DOUBLE), Default(None)
   *  @param zmin Database column zMin SqlType(DOUBLE), Default(None)
   *  @param zmax Database column zMax SqlType(DOUBLE), Default(None)
   *  @param factionid Database column factionID SqlType(INT), Default(None)
   *  @param radius Database column radius SqlType(DOUBLE), Default(None) */
  case class MapregionsRow(regionid: Int, regionname: Option[String] = None, x: Option[Double] = None, y: Option[Double] = None, z: Option[Double] = None, xmin: Option[Double] = None, xmax: Option[Double] = None, ymin: Option[Double] = None, ymax: Option[Double] = None, zmin: Option[Double] = None, zmax: Option[Double] = None, factionid: Option[Int] = None, radius: Option[Double] = None)
  /** GetResult implicit for fetching MapregionsRow objects using plain SQL queries */
  implicit def GetResultMapregionsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Double]], e3: GR[Option[Int]]): GR[MapregionsRow] = GR{
    prs => import prs._
    MapregionsRow.tupled((<<[Int], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Int], <<?[Double]))
  }
  /** Table description of table mapRegions. Objects of this class serve as prototypes for rows in queries. */
  class Mapregions(_tableTag: Tag) extends Table[MapregionsRow](_tableTag, "mapRegions") {
    def * = (regionid, regionname, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, factionid, radius) <> (MapregionsRow.tupled, MapregionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(regionid), regionname, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, factionid, radius).shaped.<>({r=>import r._; _1.map(_=> MapregionsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column regionID SqlType(INT), AutoInc, PrimaryKey */
    val regionid: Rep[Int] = column[Int]("regionID", O.AutoInc, O.PrimaryKey)
    /** Database column regionName SqlType(VARCHAR), Length(100,true), Default(None) */
    val regionname: Rep[Option[String]] = column[Option[String]]("regionName", O.Length(100,varying=true), O.Default(None))
    /** Database column x SqlType(DOUBLE), Default(None) */
    val x: Rep[Option[Double]] = column[Option[Double]]("x", O.Default(None))
    /** Database column y SqlType(DOUBLE), Default(None) */
    val y: Rep[Option[Double]] = column[Option[Double]]("y", O.Default(None))
    /** Database column z SqlType(DOUBLE), Default(None) */
    val z: Rep[Option[Double]] = column[Option[Double]]("z", O.Default(None))
    /** Database column xMin SqlType(DOUBLE), Default(None) */
    val xmin: Rep[Option[Double]] = column[Option[Double]]("xMin", O.Default(None))
    /** Database column xMax SqlType(DOUBLE), Default(None) */
    val xmax: Rep[Option[Double]] = column[Option[Double]]("xMax", O.Default(None))
    /** Database column yMin SqlType(DOUBLE), Default(None) */
    val ymin: Rep[Option[Double]] = column[Option[Double]]("yMin", O.Default(None))
    /** Database column yMax SqlType(DOUBLE), Default(None) */
    val ymax: Rep[Option[Double]] = column[Option[Double]]("yMax", O.Default(None))
    /** Database column zMin SqlType(DOUBLE), Default(None) */
    val zmin: Rep[Option[Double]] = column[Option[Double]]("zMin", O.Default(None))
    /** Database column zMax SqlType(DOUBLE), Default(None) */
    val zmax: Rep[Option[Double]] = column[Option[Double]]("zMax", O.Default(None))
    /** Database column factionID SqlType(INT), Default(None) */
    val factionid: Rep[Option[Int]] = column[Option[Int]]("factionID", O.Default(None))
    /** Database column radius SqlType(DOUBLE), Default(None) */
    val radius: Rep[Option[Double]] = column[Option[Double]]("radius", O.Default(None))
  }
  /** Collection-like TableQuery object for table Mapregions */
  lazy val Mapregions = new TableQuery(tag => new Mapregions(tag))

  /** Entity class storing rows of table Mapsolarsystemjumps
   *  @param fromregionid Database column fromRegionID SqlType(BIGINT), Default(None)
   *  @param fromconstellationid Database column fromConstellationID SqlType(BIGINT), Default(None)
   *  @param fromsolarsystemid Database column fromSolarSystemID SqlType(BIGINT)
   *  @param tosolarsystemid Database column toSolarSystemID SqlType(BIGINT)
   *  @param toconstellationid Database column toConstellationID SqlType(BIGINT), Default(None)
   *  @param toregionid Database column toRegionID SqlType(BIGINT), Default(None) */
  case class MapsolarsystemjumpsRow(fromregionid: Option[Long] = None, fromconstellationid: Option[Long] = None, fromsolarsystemid: Long, tosolarsystemid: Long, toconstellationid: Option[Long] = None, toregionid: Option[Long] = None)
  /** GetResult implicit for fetching MapsolarsystemjumpsRow objects using plain SQL queries */
  implicit def GetResultMapsolarsystemjumpsRow(implicit e0: GR[Option[Long]], e1: GR[Long]): GR[MapsolarsystemjumpsRow] = GR{
    prs => import prs._
    MapsolarsystemjumpsRow.tupled((<<?[Long], <<?[Long], <<[Long], <<[Long], <<?[Long], <<?[Long]))
  }
  /** Table description of table mapSolarSystemJumps. Objects of this class serve as prototypes for rows in queries. */
  class Mapsolarsystemjumps(_tableTag: Tag) extends Table[MapsolarsystemjumpsRow](_tableTag, "mapSolarSystemJumps") {
    def * = (fromregionid, fromconstellationid, fromsolarsystemid, tosolarsystemid, toconstellationid, toregionid) <> (MapsolarsystemjumpsRow.tupled, MapsolarsystemjumpsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (fromregionid, fromconstellationid, Rep.Some(fromsolarsystemid), Rep.Some(tosolarsystemid), toconstellationid, toregionid).shaped.<>({r=>import r._; _3.map(_=> MapsolarsystemjumpsRow.tupled((_1, _2, _3.get, _4.get, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column fromRegionID SqlType(BIGINT), Default(None) */
    val fromregionid: Rep[Option[Long]] = column[Option[Long]]("fromRegionID", O.Default(None))
    /** Database column fromConstellationID SqlType(BIGINT), Default(None) */
    val fromconstellationid: Rep[Option[Long]] = column[Option[Long]]("fromConstellationID", O.Default(None))
    /** Database column fromSolarSystemID SqlType(BIGINT) */
    val fromsolarsystemid: Rep[Long] = column[Long]("fromSolarSystemID")
    /** Database column toSolarSystemID SqlType(BIGINT) */
    val tosolarsystemid: Rep[Long] = column[Long]("toSolarSystemID")
    /** Database column toConstellationID SqlType(BIGINT), Default(None) */
    val toconstellationid: Rep[Option[Long]] = column[Option[Long]]("toConstellationID", O.Default(None))
    /** Database column toRegionID SqlType(BIGINT), Default(None) */
    val toregionid: Rep[Option[Long]] = column[Option[Long]]("toRegionID", O.Default(None))

    /** Primary key of Mapsolarsystemjumps (database name mapSolarSystemJumps_PK) */
    val pk = primaryKey("mapSolarSystemJumps_PK", (fromsolarsystemid, tosolarsystemid))
  }
  /** Collection-like TableQuery object for table Mapsolarsystemjumps */
  lazy val Mapsolarsystemjumps = new TableQuery(tag => new Mapsolarsystemjumps(tag))

  /** Row type of table Mapsolarsystems */
  type MapsolarsystemsRow = HCons[Option[Int],HCons[Option[Int],HCons[Int,HCons[Option[String],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Double],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Long],HCons[Option[Double],HCons[Option[Int],HCons[Option[Double],HCons[Option[Int],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for MapsolarsystemsRow providing default values if available in the database schema. */
  def MapsolarsystemsRow(regionid: Option[Int] = None, constellationid: Option[Int] = None, solarsystemid: Int, solarsystemname: Option[String] = None, x: Option[Double] = None, y: Option[Double] = None, z: Option[Double] = None, xmin: Option[Double] = None, xmax: Option[Double] = None, ymin: Option[Double] = None, ymax: Option[Double] = None, zmin: Option[Double] = None, zmax: Option[Double] = None, luminosity: Option[Double] = None, border: Option[Long] = None, fringe: Option[Long] = None, corridor: Option[Long] = None, hub: Option[Long] = None, international: Option[Long] = None, regional: Option[Long] = None, constellation: Option[Long] = None, security: Option[Double] = None, factionid: Option[Int] = None, radius: Option[Double] = None, suntypeid: Option[Int] = None, securityclass: Option[String] = None): MapsolarsystemsRow = {
    regionid :: constellationid :: solarsystemid :: solarsystemname :: x :: y :: z :: xmin :: xmax :: ymin :: ymax :: zmin :: zmax :: luminosity :: border :: fringe :: corridor :: hub :: international :: regional :: constellation :: security :: factionid :: radius :: suntypeid :: securityclass :: HNil
  }
  /** GetResult implicit for fetching MapsolarsystemsRow objects using plain SQL queries */
  implicit def GetResultMapsolarsystemsRow(implicit e0: GR[Option[Int]], e1: GR[Int], e2: GR[Option[String]], e3: GR[Option[Double]], e4: GR[Option[Long]]): GR[MapsolarsystemsRow] = GR{
    prs => import prs._
    <<?[Int] :: <<?[Int] :: <<[Int] :: <<?[String] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Double] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Long] :: <<?[Double] :: <<?[Int] :: <<?[Double] :: <<?[Int] :: <<?[String] :: HNil
  }
  /** Table description of table mapSolarSystems. Objects of this class serve as prototypes for rows in queries. */
  class Mapsolarsystems(_tableTag: Tag) extends Table[MapsolarsystemsRow](_tableTag, "mapSolarSystems") {
    def * = regionid :: constellationid :: solarsystemid :: solarsystemname :: x :: y :: z :: xmin :: xmax :: ymin :: ymax :: zmin :: zmax :: luminosity :: border :: fringe :: corridor :: hub :: international :: regional :: constellation :: security :: factionid :: radius :: suntypeid :: securityclass :: HNil

    /** Database column regionID SqlType(INT), Default(None) */
    val regionid: Rep[Option[Int]] = column[Option[Int]]("regionID", O.Default(None))
    /** Database column constellationID SqlType(INT), Default(None) */
    val constellationid: Rep[Option[Int]] = column[Option[Int]]("constellationID", O.Default(None))
    /** Database column solarSystemID SqlType(INT), AutoInc, PrimaryKey */
    val solarsystemid: Rep[Int] = column[Int]("solarSystemID", O.AutoInc, O.PrimaryKey)
    /** Database column solarSystemName SqlType(VARCHAR), Length(100,true), Default(None) */
    val solarsystemname: Rep[Option[String]] = column[Option[String]]("solarSystemName", O.Length(100,varying=true), O.Default(None))
    /** Database column x SqlType(DOUBLE), Default(None) */
    val x: Rep[Option[Double]] = column[Option[Double]]("x", O.Default(None))
    /** Database column y SqlType(DOUBLE), Default(None) */
    val y: Rep[Option[Double]] = column[Option[Double]]("y", O.Default(None))
    /** Database column z SqlType(DOUBLE), Default(None) */
    val z: Rep[Option[Double]] = column[Option[Double]]("z", O.Default(None))
    /** Database column xMin SqlType(DOUBLE), Default(None) */
    val xmin: Rep[Option[Double]] = column[Option[Double]]("xMin", O.Default(None))
    /** Database column xMax SqlType(DOUBLE), Default(None) */
    val xmax: Rep[Option[Double]] = column[Option[Double]]("xMax", O.Default(None))
    /** Database column yMin SqlType(DOUBLE), Default(None) */
    val ymin: Rep[Option[Double]] = column[Option[Double]]("yMin", O.Default(None))
    /** Database column yMax SqlType(DOUBLE), Default(None) */
    val ymax: Rep[Option[Double]] = column[Option[Double]]("yMax", O.Default(None))
    /** Database column zMin SqlType(DOUBLE), Default(None) */
    val zmin: Rep[Option[Double]] = column[Option[Double]]("zMin", O.Default(None))
    /** Database column zMax SqlType(DOUBLE), Default(None) */
    val zmax: Rep[Option[Double]] = column[Option[Double]]("zMax", O.Default(None))
    /** Database column luminosity SqlType(DOUBLE), Default(None) */
    val luminosity: Rep[Option[Double]] = column[Option[Double]]("luminosity", O.Default(None))
    /** Database column border SqlType(BIGINT), Default(None) */
    val border: Rep[Option[Long]] = column[Option[Long]]("border", O.Default(None))
    /** Database column fringe SqlType(BIGINT), Default(None) */
    val fringe: Rep[Option[Long]] = column[Option[Long]]("fringe", O.Default(None))
    /** Database column corridor SqlType(BIGINT), Default(None) */
    val corridor: Rep[Option[Long]] = column[Option[Long]]("corridor", O.Default(None))
    /** Database column hub SqlType(BIGINT), Default(None) */
    val hub: Rep[Option[Long]] = column[Option[Long]]("hub", O.Default(None))
    /** Database column international SqlType(BIGINT), Default(None) */
    val international: Rep[Option[Long]] = column[Option[Long]]("international", O.Default(None))
    /** Database column regional SqlType(BIGINT), Default(None) */
    val regional: Rep[Option[Long]] = column[Option[Long]]("regional", O.Default(None))
    /** Database column constellation SqlType(BIGINT), Default(None) */
    val constellation: Rep[Option[Long]] = column[Option[Long]]("constellation", O.Default(None))
    /** Database column security SqlType(DOUBLE), Default(None) */
    val security: Rep[Option[Double]] = column[Option[Double]]("security", O.Default(None))
    /** Database column factionID SqlType(INT), Default(None) */
    val factionid: Rep[Option[Int]] = column[Option[Int]]("factionID", O.Default(None))
    /** Database column radius SqlType(DOUBLE), Default(None) */
    val radius: Rep[Option[Double]] = column[Option[Double]]("radius", O.Default(None))
    /** Database column sunTypeID SqlType(INT), Default(None) */
    val suntypeid: Rep[Option[Int]] = column[Option[Int]]("sunTypeID", O.Default(None))
    /** Database column securityClass SqlType(VARCHAR), Length(2,true), Default(None) */
    val securityclass: Rep[Option[String]] = column[Option[String]]("securityClass", O.Length(2,varying=true), O.Default(None))

    /** Index over (constellationid) (database name mapSolarSystems_IX_constellation) */
    val index1 = index("mapSolarSystems_IX_constellation", constellationid :: HNil)
    /** Index over (regionid) (database name mapSolarSystems_IX_region) */
    val index2 = index("mapSolarSystems_IX_region", regionid :: HNil)
    /** Index over (security) (database name mapSolarSystems_IX_security) */
    val index3 = index("mapSolarSystems_IX_security", security :: HNil)
    /** Index over (solarsystemname) (database name mss_name) */
    val index4 = index("mss_name", solarsystemname :: HNil)
  }
  /** Collection-like TableQuery object for table Mapsolarsystems */
  lazy val Mapsolarsystems = new TableQuery(tag => new Mapsolarsystems(tag))

  /** Entity class storing rows of table Mapuniverse
   *  @param universeid Database column universeID SqlType(INT), PrimaryKey
   *  @param universename Database column universeName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param x Database column x SqlType(DOUBLE), Default(None)
   *  @param y Database column y SqlType(DOUBLE), Default(None)
   *  @param z Database column z SqlType(DOUBLE), Default(None)
   *  @param xmin Database column xMin SqlType(DOUBLE), Default(None)
   *  @param xmax Database column xMax SqlType(DOUBLE), Default(None)
   *  @param ymin Database column yMin SqlType(DOUBLE), Default(None)
   *  @param ymax Database column yMax SqlType(DOUBLE), Default(None)
   *  @param zmin Database column zMin SqlType(DOUBLE), Default(None)
   *  @param zmax Database column zMax SqlType(DOUBLE), Default(None)
   *  @param radius Database column radius SqlType(DOUBLE), Default(None) */
  case class MapuniverseRow(universeid: Int, universename: Option[String] = None, x: Option[Double] = None, y: Option[Double] = None, z: Option[Double] = None, xmin: Option[Double] = None, xmax: Option[Double] = None, ymin: Option[Double] = None, ymax: Option[Double] = None, zmin: Option[Double] = None, zmax: Option[Double] = None, radius: Option[Double] = None)
  /** GetResult implicit for fetching MapuniverseRow objects using plain SQL queries */
  implicit def GetResultMapuniverseRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Double]]): GR[MapuniverseRow] = GR{
    prs => import prs._
    MapuniverseRow.tupled((<<[Int], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table mapUniverse. Objects of this class serve as prototypes for rows in queries. */
  class Mapuniverse(_tableTag: Tag) extends Table[MapuniverseRow](_tableTag, "mapUniverse") {
    def * = (universeid, universename, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, radius) <> (MapuniverseRow.tupled, MapuniverseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(universeid), universename, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, radius).shaped.<>({r=>import r._; _1.map(_=> MapuniverseRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column universeID SqlType(INT), PrimaryKey */
    val universeid: Rep[Int] = column[Int]("universeID", O.PrimaryKey)
    /** Database column universeName SqlType(VARCHAR), Length(100,true), Default(None) */
    val universename: Rep[Option[String]] = column[Option[String]]("universeName", O.Length(100,varying=true), O.Default(None))
    /** Database column x SqlType(DOUBLE), Default(None) */
    val x: Rep[Option[Double]] = column[Option[Double]]("x", O.Default(None))
    /** Database column y SqlType(DOUBLE), Default(None) */
    val y: Rep[Option[Double]] = column[Option[Double]]("y", O.Default(None))
    /** Database column z SqlType(DOUBLE), Default(None) */
    val z: Rep[Option[Double]] = column[Option[Double]]("z", O.Default(None))
    /** Database column xMin SqlType(DOUBLE), Default(None) */
    val xmin: Rep[Option[Double]] = column[Option[Double]]("xMin", O.Default(None))
    /** Database column xMax SqlType(DOUBLE), Default(None) */
    val xmax: Rep[Option[Double]] = column[Option[Double]]("xMax", O.Default(None))
    /** Database column yMin SqlType(DOUBLE), Default(None) */
    val ymin: Rep[Option[Double]] = column[Option[Double]]("yMin", O.Default(None))
    /** Database column yMax SqlType(DOUBLE), Default(None) */
    val ymax: Rep[Option[Double]] = column[Option[Double]]("yMax", O.Default(None))
    /** Database column zMin SqlType(DOUBLE), Default(None) */
    val zmin: Rep[Option[Double]] = column[Option[Double]]("zMin", O.Default(None))
    /** Database column zMax SqlType(DOUBLE), Default(None) */
    val zmax: Rep[Option[Double]] = column[Option[Double]]("zMax", O.Default(None))
    /** Database column radius SqlType(DOUBLE), Default(None) */
    val radius: Rep[Option[Double]] = column[Option[Double]]("radius", O.Default(None))
  }
  /** Collection-like TableQuery object for table Mapuniverse */
  lazy val Mapuniverse = new TableQuery(tag => new Mapuniverse(tag))

  /** Entity class storing rows of table Planetschematics
   *  @param schematicid Database column schematicID SqlType(SMALLINT), PrimaryKey
   *  @param schematicname Database column schematicName SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param cycletime Database column cycleTime SqlType(INT), Default(None) */
  case class PlanetschematicsRow(schematicid: Short, schematicname: Option[String] = None, cycletime: Option[Int] = None)
  /** GetResult implicit for fetching PlanetschematicsRow objects using plain SQL queries */
  implicit def GetResultPlanetschematicsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[PlanetschematicsRow] = GR{
    prs => import prs._
    PlanetschematicsRow.tupled((<<[Short], <<?[String], <<?[Int]))
  }
  /** Table description of table planetSchematics. Objects of this class serve as prototypes for rows in queries. */
  class Planetschematics(_tableTag: Tag) extends Table[PlanetschematicsRow](_tableTag, "planetSchematics") {
    def * = (schematicid, schematicname, cycletime) <> (PlanetschematicsRow.tupled, PlanetschematicsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(schematicid), schematicname, cycletime).shaped.<>({r=>import r._; _1.map(_=> PlanetschematicsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column schematicID SqlType(SMALLINT), PrimaryKey */
    val schematicid: Rep[Short] = column[Short]("schematicID", O.PrimaryKey)
    /** Database column schematicName SqlType(VARCHAR), Length(255,true), Default(None) */
    val schematicname: Rep[Option[String]] = column[Option[String]]("schematicName", O.Length(255,varying=true), O.Default(None))
    /** Database column cycleTime SqlType(INT), Default(None) */
    val cycletime: Rep[Option[Int]] = column[Option[Int]]("cycleTime", O.Default(None))
  }
  /** Collection-like TableQuery object for table Planetschematics */
  lazy val Planetschematics = new TableQuery(tag => new Planetschematics(tag))

  /** Entity class storing rows of table Planetschematicspinmap
   *  @param schematicid Database column schematicID SqlType(SMALLINT)
   *  @param pintypeid Database column pinTypeID SqlType(INT) */
  case class PlanetschematicspinmapRow(schematicid: Short, pintypeid: Int)
  /** GetResult implicit for fetching PlanetschematicspinmapRow objects using plain SQL queries */
  implicit def GetResultPlanetschematicspinmapRow(implicit e0: GR[Short], e1: GR[Int]): GR[PlanetschematicspinmapRow] = GR{
    prs => import prs._
    PlanetschematicspinmapRow.tupled((<<[Short], <<[Int]))
  }
  /** Table description of table planetSchematicsPinMap. Objects of this class serve as prototypes for rows in queries. */
  class Planetschematicspinmap(_tableTag: Tag) extends Table[PlanetschematicspinmapRow](_tableTag, "planetSchematicsPinMap") {
    def * = (schematicid, pintypeid) <> (PlanetschematicspinmapRow.tupled, PlanetschematicspinmapRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(schematicid), Rep.Some(pintypeid)).shaped.<>({r=>import r._; _1.map(_=> PlanetschematicspinmapRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column schematicID SqlType(SMALLINT) */
    val schematicid: Rep[Short] = column[Short]("schematicID")
    /** Database column pinTypeID SqlType(INT) */
    val pintypeid: Rep[Int] = column[Int]("pinTypeID")

    /** Primary key of Planetschematicspinmap (database name planetSchematicsPinMap_PK) */
    val pk = primaryKey("planetSchematicsPinMap_PK", (schematicid, pintypeid))
  }
  /** Collection-like TableQuery object for table Planetschematicspinmap */
  lazy val Planetschematicspinmap = new TableQuery(tag => new Planetschematicspinmap(tag))

  /** Entity class storing rows of table Planetschematicstypemap
   *  @param schematicid Database column schematicID SqlType(SMALLINT)
   *  @param typeid Database column typeID SqlType(INT)
   *  @param quantity Database column quantity SqlType(SMALLINT), Default(None)
   *  @param isinput Database column isInput SqlType(BIT), Default(None) */
  case class PlanetschematicstypemapRow(schematicid: Short, typeid: Int, quantity: Option[Short] = None, isinput: Option[Boolean] = None)
  /** GetResult implicit for fetching PlanetschematicstypemapRow objects using plain SQL queries */
  implicit def GetResultPlanetschematicstypemapRow(implicit e0: GR[Short], e1: GR[Int], e2: GR[Option[Short]], e3: GR[Option[Boolean]]): GR[PlanetschematicstypemapRow] = GR{
    prs => import prs._
    PlanetschematicstypemapRow.tupled((<<[Short], <<[Int], <<?[Short], <<?[Boolean]))
  }
  /** Table description of table planetSchematicsTypeMap. Objects of this class serve as prototypes for rows in queries. */
  class Planetschematicstypemap(_tableTag: Tag) extends Table[PlanetschematicstypemapRow](_tableTag, "planetSchematicsTypeMap") {
    def * = (schematicid, typeid, quantity, isinput) <> (PlanetschematicstypemapRow.tupled, PlanetschematicstypemapRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(schematicid), Rep.Some(typeid), quantity, isinput).shaped.<>({r=>import r._; _1.map(_=> PlanetschematicstypemapRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column schematicID SqlType(SMALLINT) */
    val schematicid: Rep[Short] = column[Short]("schematicID")
    /** Database column typeID SqlType(INT) */
    val typeid: Rep[Int] = column[Int]("typeID")
    /** Database column quantity SqlType(SMALLINT), Default(None) */
    val quantity: Rep[Option[Short]] = column[Option[Short]]("quantity", O.Default(None))
    /** Database column isInput SqlType(BIT), Default(None) */
    val isinput: Rep[Option[Boolean]] = column[Option[Boolean]]("isInput", O.Default(None))

    /** Primary key of Planetschematicstypemap (database name planetSchematicsTypeMap_PK) */
    val pk = primaryKey("planetSchematicsTypeMap_PK", (schematicid, typeid))
  }
  /** Collection-like TableQuery object for table Planetschematicstypemap */
  lazy val Planetschematicstypemap = new TableQuery(tag => new Planetschematicstypemap(tag))

  /** Entity class storing rows of table Ramactivities
   *  @param activityid Database column activityID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param activityname Database column activityName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param iconno Database column iconNo SqlType(VARCHAR), Length(5,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param published Database column published SqlType(BIT), Default(None) */
  case class RamactivitiesRow(activityid: Byte, activityname: Option[String] = None, iconno: Option[String] = None, description: Option[String] = None, published: Option[Boolean] = None)
  /** GetResult implicit for fetching RamactivitiesRow objects using plain SQL queries */
  implicit def GetResultRamactivitiesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Boolean]]): GR[RamactivitiesRow] = GR{
    prs => import prs._
    RamactivitiesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[String], <<?[Boolean]))
  }
  /** Table description of table ramActivities. Objects of this class serve as prototypes for rows in queries. */
  class Ramactivities(_tableTag: Tag) extends Table[RamactivitiesRow](_tableTag, "ramActivities") {
    def * = (activityid, activityname, iconno, description, published) <> (RamactivitiesRow.tupled, RamactivitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(activityid), activityname, iconno, description, published).shaped.<>({r=>import r._; _1.map(_=> RamactivitiesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column activityID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val activityid: Rep[Byte] = column[Byte]("activityID", O.PrimaryKey)
    /** Database column activityName SqlType(VARCHAR), Length(100,true), Default(None) */
    val activityname: Rep[Option[String]] = column[Option[String]]("activityName", O.Length(100,varying=true), O.Default(None))
    /** Database column iconNo SqlType(VARCHAR), Length(5,true), Default(None) */
    val iconno: Rep[Option[String]] = column[Option[String]]("iconNo", O.Length(5,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column published SqlType(BIT), Default(None) */
    val published: Rep[Option[Boolean]] = column[Option[Boolean]]("published", O.Default(None))
  }
  /** Collection-like TableQuery object for table Ramactivities */
  lazy val Ramactivities = new TableQuery(tag => new Ramactivities(tag))

  /** Entity class storing rows of table Ramassemblylinestations
   *  @param stationid Database column stationID SqlType(INT)
   *  @param assemblylinetypeid Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED)
   *  @param quantity Database column quantity SqlType(TINYINT UNSIGNED), Default(None)
   *  @param stationtypeid Database column stationTypeID SqlType(INT), Default(None)
   *  @param ownerid Database column ownerID SqlType(INT), Default(None)
   *  @param solarsystemid Database column solarSystemID SqlType(INT), Default(None)
   *  @param regionid Database column regionID SqlType(INT), Default(None) */
  case class RamassemblylinestationsRow(stationid: Int, assemblylinetypeid: Byte, quantity: Option[Byte] = None, stationtypeid: Option[Int] = None, ownerid: Option[Int] = None, solarsystemid: Option[Int] = None, regionid: Option[Int] = None)
  /** GetResult implicit for fetching RamassemblylinestationsRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinestationsRow(implicit e0: GR[Int], e1: GR[Byte], e2: GR[Option[Byte]], e3: GR[Option[Int]]): GR[RamassemblylinestationsRow] = GR{
    prs => import prs._
    RamassemblylinestationsRow.tupled((<<[Int], <<[Byte], <<?[Byte], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table ramAssemblyLineStations. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinestations(_tableTag: Tag) extends Table[RamassemblylinestationsRow](_tableTag, "ramAssemblyLineStations") {
    def * = (stationid, assemblylinetypeid, quantity, stationtypeid, ownerid, solarsystemid, regionid) <> (RamassemblylinestationsRow.tupled, RamassemblylinestationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(stationid), Rep.Some(assemblylinetypeid), quantity, stationtypeid, ownerid, solarsystemid, regionid).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinestationsRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column stationID SqlType(INT) */
    val stationid: Rep[Int] = column[Int]("stationID")
    /** Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED) */
    val assemblylinetypeid: Rep[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column quantity SqlType(TINYINT UNSIGNED), Default(None) */
    val quantity: Rep[Option[Byte]] = column[Option[Byte]]("quantity", O.Default(None))
    /** Database column stationTypeID SqlType(INT), Default(None) */
    val stationtypeid: Rep[Option[Int]] = column[Option[Int]]("stationTypeID", O.Default(None))
    /** Database column ownerID SqlType(INT), Default(None) */
    val ownerid: Rep[Option[Int]] = column[Option[Int]]("ownerID", O.Default(None))
    /** Database column solarSystemID SqlType(INT), Default(None) */
    val solarsystemid: Rep[Option[Int]] = column[Option[Int]]("solarSystemID", O.Default(None))
    /** Database column regionID SqlType(INT), Default(None) */
    val regionid: Rep[Option[Int]] = column[Option[Int]]("regionID", O.Default(None))

    /** Primary key of Ramassemblylinestations (database name ramAssemblyLineStations_PK) */
    val pk = primaryKey("ramAssemblyLineStations_PK", (stationid, assemblylinetypeid))

    /** Index over (ownerid) (database name ramAssemblyLineStations_IX_owner) */
    val index1 = index("ramAssemblyLineStations_IX_owner", ownerid)
    /** Index over (regionid) (database name ramAssemblyLineStations_IX_region) */
    val index2 = index("ramAssemblyLineStations_IX_region", regionid)
  }
  /** Collection-like TableQuery object for table Ramassemblylinestations */
  lazy val Ramassemblylinestations = new TableQuery(tag => new Ramassemblylinestations(tag))

  /** Entity class storing rows of table Ramassemblylinetypedetailpercategory
   *  @param assemblylinetypeid Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED)
   *  @param categoryid Database column categoryID SqlType(INT)
   *  @param timemultiplier Database column timeMultiplier SqlType(DOUBLE), Default(None)
   *  @param materialmultiplier Database column materialMultiplier SqlType(DOUBLE), Default(None)
   *  @param costmultiplier Database column costMultiplier SqlType(DOUBLE), Default(None) */
  case class RamassemblylinetypedetailpercategoryRow(assemblylinetypeid: Byte, categoryid: Int, timemultiplier: Option[Double] = None, materialmultiplier: Option[Double] = None, costmultiplier: Option[Double] = None)
  /** GetResult implicit for fetching RamassemblylinetypedetailpercategoryRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinetypedetailpercategoryRow(implicit e0: GR[Byte], e1: GR[Int], e2: GR[Option[Double]]): GR[RamassemblylinetypedetailpercategoryRow] = GR{
    prs => import prs._
    RamassemblylinetypedetailpercategoryRow.tupled((<<[Byte], <<[Int], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table ramAssemblyLineTypeDetailPerCategory. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinetypedetailpercategory(_tableTag: Tag) extends Table[RamassemblylinetypedetailpercategoryRow](_tableTag, "ramAssemblyLineTypeDetailPerCategory") {
    def * = (assemblylinetypeid, categoryid, timemultiplier, materialmultiplier, costmultiplier) <> (RamassemblylinetypedetailpercategoryRow.tupled, RamassemblylinetypedetailpercategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(assemblylinetypeid), Rep.Some(categoryid), timemultiplier, materialmultiplier, costmultiplier).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinetypedetailpercategoryRow.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED) */
    val assemblylinetypeid: Rep[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column categoryID SqlType(INT) */
    val categoryid: Rep[Int] = column[Int]("categoryID")
    /** Database column timeMultiplier SqlType(DOUBLE), Default(None) */
    val timemultiplier: Rep[Option[Double]] = column[Option[Double]]("timeMultiplier", O.Default(None))
    /** Database column materialMultiplier SqlType(DOUBLE), Default(None) */
    val materialmultiplier: Rep[Option[Double]] = column[Option[Double]]("materialMultiplier", O.Default(None))
    /** Database column costMultiplier SqlType(DOUBLE), Default(None) */
    val costmultiplier: Rep[Option[Double]] = column[Option[Double]]("costMultiplier", O.Default(None))

    /** Primary key of Ramassemblylinetypedetailpercategory (database name ramAssemblyLineTypeDetailPerCategory_PK) */
    val pk = primaryKey("ramAssemblyLineTypeDetailPerCategory_PK", (assemblylinetypeid, categoryid))
  }
  /** Collection-like TableQuery object for table Ramassemblylinetypedetailpercategory */
  lazy val Ramassemblylinetypedetailpercategory = new TableQuery(tag => new Ramassemblylinetypedetailpercategory(tag))

  /** Entity class storing rows of table Ramassemblylinetypedetailpergroup
   *  @param assemblylinetypeid Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED)
   *  @param groupid Database column groupID SqlType(INT)
   *  @param timemultiplier Database column timeMultiplier SqlType(DOUBLE), Default(None)
   *  @param materialmultiplier Database column materialMultiplier SqlType(DOUBLE), Default(None)
   *  @param costmultiplier Database column costMultiplier SqlType(DOUBLE), Default(None) */
  case class RamassemblylinetypedetailpergroupRow(assemblylinetypeid: Byte, groupid: Int, timemultiplier: Option[Double] = None, materialmultiplier: Option[Double] = None, costmultiplier: Option[Double] = None)
  /** GetResult implicit for fetching RamassemblylinetypedetailpergroupRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinetypedetailpergroupRow(implicit e0: GR[Byte], e1: GR[Int], e2: GR[Option[Double]]): GR[RamassemblylinetypedetailpergroupRow] = GR{
    prs => import prs._
    RamassemblylinetypedetailpergroupRow.tupled((<<[Byte], <<[Int], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table ramAssemblyLineTypeDetailPerGroup. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinetypedetailpergroup(_tableTag: Tag) extends Table[RamassemblylinetypedetailpergroupRow](_tableTag, "ramAssemblyLineTypeDetailPerGroup") {
    def * = (assemblylinetypeid, groupid, timemultiplier, materialmultiplier, costmultiplier) <> (RamassemblylinetypedetailpergroupRow.tupled, RamassemblylinetypedetailpergroupRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(assemblylinetypeid), Rep.Some(groupid), timemultiplier, materialmultiplier, costmultiplier).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinetypedetailpergroupRow.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED) */
    val assemblylinetypeid: Rep[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column groupID SqlType(INT) */
    val groupid: Rep[Int] = column[Int]("groupID")
    /** Database column timeMultiplier SqlType(DOUBLE), Default(None) */
    val timemultiplier: Rep[Option[Double]] = column[Option[Double]]("timeMultiplier", O.Default(None))
    /** Database column materialMultiplier SqlType(DOUBLE), Default(None) */
    val materialmultiplier: Rep[Option[Double]] = column[Option[Double]]("materialMultiplier", O.Default(None))
    /** Database column costMultiplier SqlType(DOUBLE), Default(None) */
    val costmultiplier: Rep[Option[Double]] = column[Option[Double]]("costMultiplier", O.Default(None))

    /** Primary key of Ramassemblylinetypedetailpergroup (database name ramAssemblyLineTypeDetailPerGroup_PK) */
    val pk = primaryKey("ramAssemblyLineTypeDetailPerGroup_PK", (assemblylinetypeid, groupid))
  }
  /** Collection-like TableQuery object for table Ramassemblylinetypedetailpergroup */
  lazy val Ramassemblylinetypedetailpergroup = new TableQuery(tag => new Ramassemblylinetypedetailpergroup(tag))

  /** Entity class storing rows of table Ramassemblylinetypes
   *  @param assemblylinetypeid Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param assemblylinetypename Database column assemblyLineTypeName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param basetimemultiplier Database column baseTimeMultiplier SqlType(DOUBLE), Default(None)
   *  @param basematerialmultiplier Database column baseMaterialMultiplier SqlType(DOUBLE), Default(None)
   *  @param basecostmultiplier Database column baseCostMultiplier SqlType(DOUBLE), Default(None)
   *  @param volume Database column volume SqlType(DOUBLE), Default(None)
   *  @param activityid Database column activityID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param mincostperhour Database column minCostPerHour SqlType(DOUBLE), Default(None) */
  case class RamassemblylinetypesRow(assemblylinetypeid: Byte, assemblylinetypename: Option[String] = None, description: Option[String] = None, basetimemultiplier: Option[Double] = None, basematerialmultiplier: Option[Double] = None, basecostmultiplier: Option[Double] = None, volume: Option[Double] = None, activityid: Option[Byte] = None, mincostperhour: Option[Double] = None)
  /** GetResult implicit for fetching RamassemblylinetypesRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinetypesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Double]], e3: GR[Option[Byte]]): GR[RamassemblylinetypesRow] = GR{
    prs => import prs._
    RamassemblylinetypesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Byte], <<?[Double]))
  }
  /** Table description of table ramAssemblyLineTypes. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinetypes(_tableTag: Tag) extends Table[RamassemblylinetypesRow](_tableTag, "ramAssemblyLineTypes") {
    def * = (assemblylinetypeid, assemblylinetypename, description, basetimemultiplier, basematerialmultiplier, basecostmultiplier, volume, activityid, mincostperhour) <> (RamassemblylinetypesRow.tupled, RamassemblylinetypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(assemblylinetypeid), assemblylinetypename, description, basetimemultiplier, basematerialmultiplier, basecostmultiplier, volume, activityid, mincostperhour).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinetypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val assemblylinetypeid: Rep[Byte] = column[Byte]("assemblyLineTypeID", O.PrimaryKey)
    /** Database column assemblyLineTypeName SqlType(VARCHAR), Length(100,true), Default(None) */
    val assemblylinetypename: Rep[Option[String]] = column[Option[String]]("assemblyLineTypeName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column baseTimeMultiplier SqlType(DOUBLE), Default(None) */
    val basetimemultiplier: Rep[Option[Double]] = column[Option[Double]]("baseTimeMultiplier", O.Default(None))
    /** Database column baseMaterialMultiplier SqlType(DOUBLE), Default(None) */
    val basematerialmultiplier: Rep[Option[Double]] = column[Option[Double]]("baseMaterialMultiplier", O.Default(None))
    /** Database column baseCostMultiplier SqlType(DOUBLE), Default(None) */
    val basecostmultiplier: Rep[Option[Double]] = column[Option[Double]]("baseCostMultiplier", O.Default(None))
    /** Database column volume SqlType(DOUBLE), Default(None) */
    val volume: Rep[Option[Double]] = column[Option[Double]]("volume", O.Default(None))
    /** Database column activityID SqlType(TINYINT UNSIGNED), Default(None) */
    val activityid: Rep[Option[Byte]] = column[Option[Byte]]("activityID", O.Default(None))
    /** Database column minCostPerHour SqlType(DOUBLE), Default(None) */
    val mincostperhour: Rep[Option[Double]] = column[Option[Double]]("minCostPerHour", O.Default(None))
  }
  /** Collection-like TableQuery object for table Ramassemblylinetypes */
  lazy val Ramassemblylinetypes = new TableQuery(tag => new Ramassemblylinetypes(tag))

  /** Entity class storing rows of table Raminstallationtypecontents
   *  @param installationtypeid Database column installationTypeID SqlType(INT)
   *  @param assemblylinetypeid Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED)
   *  @param quantity Database column quantity SqlType(TINYINT UNSIGNED), Default(None) */
  case class RaminstallationtypecontentsRow(installationtypeid: Int, assemblylinetypeid: Byte, quantity: Option[Byte] = None)
  /** GetResult implicit for fetching RaminstallationtypecontentsRow objects using plain SQL queries */
  implicit def GetResultRaminstallationtypecontentsRow(implicit e0: GR[Int], e1: GR[Byte], e2: GR[Option[Byte]]): GR[RaminstallationtypecontentsRow] = GR{
    prs => import prs._
    RaminstallationtypecontentsRow.tupled((<<[Int], <<[Byte], <<?[Byte]))
  }
  /** Table description of table ramInstallationTypeContents. Objects of this class serve as prototypes for rows in queries. */
  class Raminstallationtypecontents(_tableTag: Tag) extends Table[RaminstallationtypecontentsRow](_tableTag, "ramInstallationTypeContents") {
    def * = (installationtypeid, assemblylinetypeid, quantity) <> (RaminstallationtypecontentsRow.tupled, RaminstallationtypecontentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(installationtypeid), Rep.Some(assemblylinetypeid), quantity).shaped.<>({r=>import r._; _1.map(_=> RaminstallationtypecontentsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column installationTypeID SqlType(INT) */
    val installationtypeid: Rep[Int] = column[Int]("installationTypeID")
    /** Database column assemblyLineTypeID SqlType(TINYINT UNSIGNED) */
    val assemblylinetypeid: Rep[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column quantity SqlType(TINYINT UNSIGNED), Default(None) */
    val quantity: Rep[Option[Byte]] = column[Option[Byte]]("quantity", O.Default(None))

    /** Primary key of Raminstallationtypecontents (database name ramInstallationTypeContents_PK) */
    val pk = primaryKey("ramInstallationTypeContents_PK", (installationtypeid, assemblylinetypeid))
  }
  /** Collection-like TableQuery object for table Raminstallationtypecontents */
  lazy val Raminstallationtypecontents = new TableQuery(tag => new Raminstallationtypecontents(tag))

  /** Entity class storing rows of table Skinlicense
   *  @param licensetypeid Database column licenseTypeID SqlType(INT), PrimaryKey
   *  @param duration Database column duration SqlType(INT), Default(None)
   *  @param skinid Database column skinID SqlType(INT), Default(None) */
  case class SkinlicenseRow(licensetypeid: Int, duration: Option[Int] = None, skinid: Option[Int] = None)
  /** GetResult implicit for fetching SkinlicenseRow objects using plain SQL queries */
  implicit def GetResultSkinlicenseRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[SkinlicenseRow] = GR{
    prs => import prs._
    SkinlicenseRow.tupled((<<[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table skinLicense. Objects of this class serve as prototypes for rows in queries. */
  class Skinlicense(_tableTag: Tag) extends Table[SkinlicenseRow](_tableTag, "skinLicense") {
    def * = (licensetypeid, duration, skinid) <> (SkinlicenseRow.tupled, SkinlicenseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(licensetypeid), duration, skinid).shaped.<>({r=>import r._; _1.map(_=> SkinlicenseRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column licenseTypeID SqlType(INT), PrimaryKey */
    val licensetypeid: Rep[Int] = column[Int]("licenseTypeID", O.PrimaryKey)
    /** Database column duration SqlType(INT), Default(None) */
    val duration: Rep[Option[Int]] = column[Option[Int]]("duration", O.Default(None))
    /** Database column skinID SqlType(INT), Default(None) */
    val skinid: Rep[Option[Int]] = column[Option[Int]]("skinID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Skinlicense */
  lazy val Skinlicense = new TableQuery(tag => new Skinlicense(tag))

  /** Entity class storing rows of table Skinmaterials
   *  @param skinmaterialid Database column skinMaterialID SqlType(INT), PrimaryKey
   *  @param displaynameid Database column displayNameID SqlType(INT), Default(None)
   *  @param materialsetid Database column materialSetID SqlType(INT), Default(None) */
  case class SkinmaterialsRow(skinmaterialid: Int, displaynameid: Option[Int] = None, materialsetid: Option[Int] = None)
  /** GetResult implicit for fetching SkinmaterialsRow objects using plain SQL queries */
  implicit def GetResultSkinmaterialsRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[SkinmaterialsRow] = GR{
    prs => import prs._
    SkinmaterialsRow.tupled((<<[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table skinMaterials. Objects of this class serve as prototypes for rows in queries. */
  class Skinmaterials(_tableTag: Tag) extends Table[SkinmaterialsRow](_tableTag, "skinMaterials") {
    def * = (skinmaterialid, displaynameid, materialsetid) <> (SkinmaterialsRow.tupled, SkinmaterialsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(skinmaterialid), displaynameid, materialsetid).shaped.<>({r=>import r._; _1.map(_=> SkinmaterialsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column skinMaterialID SqlType(INT), PrimaryKey */
    val skinmaterialid: Rep[Int] = column[Int]("skinMaterialID", O.PrimaryKey)
    /** Database column displayNameID SqlType(INT), Default(None) */
    val displaynameid: Rep[Option[Int]] = column[Option[Int]]("displayNameID", O.Default(None))
    /** Database column materialSetID SqlType(INT), Default(None) */
    val materialsetid: Rep[Option[Int]] = column[Option[Int]]("materialSetID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Skinmaterials */
  lazy val Skinmaterials = new TableQuery(tag => new Skinmaterials(tag))

  /** Entity class storing rows of table Skins
   *  @param skinid Database column skinID SqlType(INT), PrimaryKey
   *  @param internalname Database column internalName SqlType(VARCHAR), Length(70,true), Default(None)
   *  @param skinmaterialid Database column skinMaterialID SqlType(INT), Default(None) */
  case class SkinsRow(skinid: Int, internalname: Option[String] = None, skinmaterialid: Option[Int] = None)
  /** GetResult implicit for fetching SkinsRow objects using plain SQL queries */
  implicit def GetResultSkinsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[SkinsRow] = GR{
    prs => import prs._
    SkinsRow.tupled((<<[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table skins. Objects of this class serve as prototypes for rows in queries. */
  class Skins(_tableTag: Tag) extends Table[SkinsRow](_tableTag, "skins") {
    def * = (skinid, internalname, skinmaterialid) <> (SkinsRow.tupled, SkinsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(skinid), internalname, skinmaterialid).shaped.<>({r=>import r._; _1.map(_=> SkinsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column skinID SqlType(INT), PrimaryKey */
    val skinid: Rep[Int] = column[Int]("skinID", O.PrimaryKey)
    /** Database column internalName SqlType(VARCHAR), Length(70,true), Default(None) */
    val internalname: Rep[Option[String]] = column[Option[String]]("internalName", O.Length(70,varying=true), O.Default(None))
    /** Database column skinMaterialID SqlType(INT), Default(None) */
    val skinmaterialid: Rep[Option[Int]] = column[Option[Int]]("skinMaterialID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Skins */
  lazy val Skins = new TableQuery(tag => new Skins(tag))

  /** Entity class storing rows of table Skinship
   *  @param skinid Database column skinID SqlType(INT), Default(None)
   *  @param typeid Database column typeID SqlType(INT), Default(None) */
  case class SkinshipRow(skinid: Option[Int] = None, typeid: Option[Int] = None)
  /** GetResult implicit for fetching SkinshipRow objects using plain SQL queries */
  implicit def GetResultSkinshipRow(implicit e0: GR[Option[Int]]): GR[SkinshipRow] = GR{
    prs => import prs._
    SkinshipRow.tupled((<<?[Int], <<?[Int]))
  }
  /** Table description of table skinShip. Objects of this class serve as prototypes for rows in queries. */
  class Skinship(_tableTag: Tag) extends Table[SkinshipRow](_tableTag, "skinShip") {
    def * = (skinid, typeid) <> (SkinshipRow.tupled, SkinshipRow.unapply)

    /** Database column skinID SqlType(INT), Default(None) */
    val skinid: Rep[Option[Int]] = column[Option[Int]]("skinID", O.Default(None))
    /** Database column typeID SqlType(INT), Default(None) */
    val typeid: Rep[Option[Int]] = column[Option[Int]]("typeID", O.Default(None))

    /** Index over (skinid) (database name ix_skinShip_skinID) */
    val index1 = index("ix_skinShip_skinID", skinid)
    /** Index over (typeid) (database name ix_skinShip_typeID) */
    val index2 = index("ix_skinShip_typeID", typeid)
  }
  /** Collection-like TableQuery object for table Skinship */
  lazy val Skinship = new TableQuery(tag => new Skinship(tag))

  /** Entity class storing rows of table Staoperations
   *  @param activityid Database column activityID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param operationid Database column operationID SqlType(TINYINT UNSIGNED), PrimaryKey
   *  @param operationname Database column operationName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None)
   *  @param fringe Database column fringe SqlType(TINYINT UNSIGNED), Default(None)
   *  @param corridor Database column corridor SqlType(TINYINT UNSIGNED), Default(None)
   *  @param hub Database column hub SqlType(TINYINT UNSIGNED), Default(None)
   *  @param border Database column border SqlType(TINYINT UNSIGNED), Default(None)
   *  @param ratio Database column ratio SqlType(TINYINT UNSIGNED), Default(None)
   *  @param caldaristationtypeid Database column caldariStationTypeID SqlType(INT), Default(None)
   *  @param minmatarstationtypeid Database column minmatarStationTypeID SqlType(INT), Default(None)
   *  @param amarrstationtypeid Database column amarrStationTypeID SqlType(INT), Default(None)
   *  @param gallentestationtypeid Database column gallenteStationTypeID SqlType(INT), Default(None)
   *  @param jovestationtypeid Database column joveStationTypeID SqlType(INT), Default(None) */
  case class StaoperationsRow(activityid: Option[Byte] = None, operationid: Byte, operationname: Option[String] = None, description: Option[String] = None, fringe: Option[Byte] = None, corridor: Option[Byte] = None, hub: Option[Byte] = None, border: Option[Byte] = None, ratio: Option[Byte] = None, caldaristationtypeid: Option[Int] = None, minmatarstationtypeid: Option[Int] = None, amarrstationtypeid: Option[Int] = None, gallentestationtypeid: Option[Int] = None, jovestationtypeid: Option[Int] = None)
  /** GetResult implicit for fetching StaoperationsRow objects using plain SQL queries */
  implicit def GetResultStaoperationsRow(implicit e0: GR[Option[Byte]], e1: GR[Byte], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[StaoperationsRow] = GR{
    prs => import prs._
    StaoperationsRow.tupled((<<?[Byte], <<[Byte], <<?[String], <<?[String], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table staOperations. Objects of this class serve as prototypes for rows in queries. */
  class Staoperations(_tableTag: Tag) extends Table[StaoperationsRow](_tableTag, "staOperations") {
    def * = (activityid, operationid, operationname, description, fringe, corridor, hub, border, ratio, caldaristationtypeid, minmatarstationtypeid, amarrstationtypeid, gallentestationtypeid, jovestationtypeid) <> (StaoperationsRow.tupled, StaoperationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (activityid, Rep.Some(operationid), operationname, description, fringe, corridor, hub, border, ratio, caldaristationtypeid, minmatarstationtypeid, amarrstationtypeid, gallentestationtypeid, jovestationtypeid).shaped.<>({r=>import r._; _2.map(_=> StaoperationsRow.tupled((_1, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column activityID SqlType(TINYINT UNSIGNED), Default(None) */
    val activityid: Rep[Option[Byte]] = column[Option[Byte]]("activityID", O.Default(None))
    /** Database column operationID SqlType(TINYINT UNSIGNED), PrimaryKey */
    val operationid: Rep[Byte] = column[Byte]("operationID", O.PrimaryKey)
    /** Database column operationName SqlType(VARCHAR), Length(100,true), Default(None) */
    val operationname: Rep[Option[String]] = column[Option[String]]("operationName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
    /** Database column fringe SqlType(TINYINT UNSIGNED), Default(None) */
    val fringe: Rep[Option[Byte]] = column[Option[Byte]]("fringe", O.Default(None))
    /** Database column corridor SqlType(TINYINT UNSIGNED), Default(None) */
    val corridor: Rep[Option[Byte]] = column[Option[Byte]]("corridor", O.Default(None))
    /** Database column hub SqlType(TINYINT UNSIGNED), Default(None) */
    val hub: Rep[Option[Byte]] = column[Option[Byte]]("hub", O.Default(None))
    /** Database column border SqlType(TINYINT UNSIGNED), Default(None) */
    val border: Rep[Option[Byte]] = column[Option[Byte]]("border", O.Default(None))
    /** Database column ratio SqlType(TINYINT UNSIGNED), Default(None) */
    val ratio: Rep[Option[Byte]] = column[Option[Byte]]("ratio", O.Default(None))
    /** Database column caldariStationTypeID SqlType(INT), Default(None) */
    val caldaristationtypeid: Rep[Option[Int]] = column[Option[Int]]("caldariStationTypeID", O.Default(None))
    /** Database column minmatarStationTypeID SqlType(INT), Default(None) */
    val minmatarstationtypeid: Rep[Option[Int]] = column[Option[Int]]("minmatarStationTypeID", O.Default(None))
    /** Database column amarrStationTypeID SqlType(INT), Default(None) */
    val amarrstationtypeid: Rep[Option[Int]] = column[Option[Int]]("amarrStationTypeID", O.Default(None))
    /** Database column gallenteStationTypeID SqlType(INT), Default(None) */
    val gallentestationtypeid: Rep[Option[Int]] = column[Option[Int]]("gallenteStationTypeID", O.Default(None))
    /** Database column joveStationTypeID SqlType(INT), Default(None) */
    val jovestationtypeid: Rep[Option[Int]] = column[Option[Int]]("joveStationTypeID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Staoperations */
  lazy val Staoperations = new TableQuery(tag => new Staoperations(tag))

  /** Entity class storing rows of table Staoperationservices
   *  @param operationid Database column operationID SqlType(TINYINT UNSIGNED)
   *  @param serviceid Database column serviceID SqlType(INT) */
  case class StaoperationservicesRow(operationid: Byte, serviceid: Int)
  /** GetResult implicit for fetching StaoperationservicesRow objects using plain SQL queries */
  implicit def GetResultStaoperationservicesRow(implicit e0: GR[Byte], e1: GR[Int]): GR[StaoperationservicesRow] = GR{
    prs => import prs._
    StaoperationservicesRow.tupled((<<[Byte], <<[Int]))
  }
  /** Table description of table staOperationServices. Objects of this class serve as prototypes for rows in queries. */
  class Staoperationservices(_tableTag: Tag) extends Table[StaoperationservicesRow](_tableTag, "staOperationServices") {
    def * = (operationid, serviceid) <> (StaoperationservicesRow.tupled, StaoperationservicesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(operationid), Rep.Some(serviceid)).shaped.<>({r=>import r._; _1.map(_=> StaoperationservicesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column operationID SqlType(TINYINT UNSIGNED) */
    val operationid: Rep[Byte] = column[Byte]("operationID")
    /** Database column serviceID SqlType(INT) */
    val serviceid: Rep[Int] = column[Int]("serviceID")

    /** Primary key of Staoperationservices (database name staOperationServices_PK) */
    val pk = primaryKey("staOperationServices_PK", (operationid, serviceid))
  }
  /** Collection-like TableQuery object for table Staoperationservices */
  lazy val Staoperationservices = new TableQuery(tag => new Staoperationservices(tag))

  /** Entity class storing rows of table Staservices
   *  @param serviceid Database column serviceID SqlType(INT), PrimaryKey
   *  @param servicename Database column serviceName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
  case class StaservicesRow(serviceid: Int, servicename: Option[String] = None, description: Option[String] = None)
  /** GetResult implicit for fetching StaservicesRow objects using plain SQL queries */
  implicit def GetResultStaservicesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[StaservicesRow] = GR{
    prs => import prs._
    StaservicesRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table staServices. Objects of this class serve as prototypes for rows in queries. */
  class Staservices(_tableTag: Tag) extends Table[StaservicesRow](_tableTag, "staServices") {
    def * = (serviceid, servicename, description) <> (StaservicesRow.tupled, StaservicesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(serviceid), servicename, description).shaped.<>({r=>import r._; _1.map(_=> StaservicesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column serviceID SqlType(INT), PrimaryKey */
    val serviceid: Rep[Int] = column[Int]("serviceID", O.PrimaryKey)
    /** Database column serviceName SqlType(VARCHAR), Length(100,true), Default(None) */
    val servicename: Rep[Option[String]] = column[Option[String]]("serviceName", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(1000,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Staservices */
  lazy val Staservices = new TableQuery(tag => new Staservices(tag))

  /** Entity class storing rows of table Stastations
   *  @param stationid Database column stationID SqlType(INT), PrimaryKey
   *  @param security Database column security SqlType(SMALLINT), Default(None)
   *  @param dockingcostpervolume Database column dockingCostPerVolume SqlType(DOUBLE), Default(None)
   *  @param maxshipvolumedockable Database column maxShipVolumeDockable SqlType(DOUBLE), Default(None)
   *  @param officerentalcost Database column officeRentalCost SqlType(INT), Default(None)
   *  @param operationid Database column operationID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param stationtypeid Database column stationTypeID SqlType(INT), Default(None)
   *  @param corporationid Database column corporationID SqlType(INT), Default(None)
   *  @param solarsystemid Database column solarSystemID SqlType(INT), Default(None)
   *  @param constellationid Database column constellationID SqlType(INT), Default(None)
   *  @param regionid Database column regionID SqlType(INT), Default(None)
   *  @param stationname Database column stationName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param x Database column x SqlType(DOUBLE), Default(None)
   *  @param y Database column y SqlType(DOUBLE), Default(None)
   *  @param z Database column z SqlType(DOUBLE), Default(None)
   *  @param reprocessingefficiency Database column reprocessingEfficiency SqlType(DOUBLE), Default(None)
   *  @param reprocessingstationstake Database column reprocessingStationsTake SqlType(DOUBLE), Default(None)
   *  @param reprocessinghangarflag Database column reprocessingHangarFlag SqlType(TINYINT UNSIGNED), Default(None) */
  case class StastationsRow(stationid: Int, security: Option[Short] = None, dockingcostpervolume: Option[Double] = None, maxshipvolumedockable: Option[Double] = None, officerentalcost: Option[Int] = None, operationid: Option[Byte] = None, stationtypeid: Option[Int] = None, corporationid: Option[Int] = None, solarsystemid: Option[Int] = None, constellationid: Option[Int] = None, regionid: Option[Int] = None, stationname: Option[String] = None, x: Option[Double] = None, y: Option[Double] = None, z: Option[Double] = None, reprocessingefficiency: Option[Double] = None, reprocessingstationstake: Option[Double] = None, reprocessinghangarflag: Option[Byte] = None)
  /** GetResult implicit for fetching StastationsRow objects using plain SQL queries */
  implicit def GetResultStastationsRow(implicit e0: GR[Int], e1: GR[Option[Short]], e2: GR[Option[Double]], e3: GR[Option[Int]], e4: GR[Option[Byte]], e5: GR[Option[String]]): GR[StastationsRow] = GR{
    prs => import prs._
    StastationsRow.tupled((<<[Int], <<?[Short], <<?[Double], <<?[Double], <<?[Int], <<?[Byte], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Byte]))
  }
  /** Table description of table staStations. Objects of this class serve as prototypes for rows in queries. */
  class Stastations(_tableTag: Tag) extends Table[StastationsRow](_tableTag, "staStations") {
    def * = (stationid, security, dockingcostpervolume, maxshipvolumedockable, officerentalcost, operationid, stationtypeid, corporationid, solarsystemid, constellationid, regionid, stationname, x, y, z, reprocessingefficiency, reprocessingstationstake, reprocessinghangarflag) <> (StastationsRow.tupled, StastationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(stationid), security, dockingcostpervolume, maxshipvolumedockable, officerentalcost, operationid, stationtypeid, corporationid, solarsystemid, constellationid, regionid, stationname, x, y, z, reprocessingefficiency, reprocessingstationstake, reprocessinghangarflag).shaped.<>({r=>import r._; _1.map(_=> StastationsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column stationID SqlType(INT), PrimaryKey */
    val stationid: Rep[Int] = column[Int]("stationID", O.PrimaryKey)
    /** Database column security SqlType(SMALLINT), Default(None) */
    val security: Rep[Option[Short]] = column[Option[Short]]("security", O.Default(None))
    /** Database column dockingCostPerVolume SqlType(DOUBLE), Default(None) */
    val dockingcostpervolume: Rep[Option[Double]] = column[Option[Double]]("dockingCostPerVolume", O.Default(None))
    /** Database column maxShipVolumeDockable SqlType(DOUBLE), Default(None) */
    val maxshipvolumedockable: Rep[Option[Double]] = column[Option[Double]]("maxShipVolumeDockable", O.Default(None))
    /** Database column officeRentalCost SqlType(INT), Default(None) */
    val officerentalcost: Rep[Option[Int]] = column[Option[Int]]("officeRentalCost", O.Default(None))
    /** Database column operationID SqlType(TINYINT UNSIGNED), Default(None) */
    val operationid: Rep[Option[Byte]] = column[Option[Byte]]("operationID", O.Default(None))
    /** Database column stationTypeID SqlType(INT), Default(None) */
    val stationtypeid: Rep[Option[Int]] = column[Option[Int]]("stationTypeID", O.Default(None))
    /** Database column corporationID SqlType(INT), Default(None) */
    val corporationid: Rep[Option[Int]] = column[Option[Int]]("corporationID", O.Default(None))
    /** Database column solarSystemID SqlType(INT), Default(None) */
    val solarsystemid: Rep[Option[Int]] = column[Option[Int]]("solarSystemID", O.Default(None))
    /** Database column constellationID SqlType(INT), Default(None) */
    val constellationid: Rep[Option[Int]] = column[Option[Int]]("constellationID", O.Default(None))
    /** Database column regionID SqlType(INT), Default(None) */
    val regionid: Rep[Option[Int]] = column[Option[Int]]("regionID", O.Default(None))
    /** Database column stationName SqlType(VARCHAR), Length(100,true), Default(None) */
    val stationname: Rep[Option[String]] = column[Option[String]]("stationName", O.Length(100,varying=true), O.Default(None))
    /** Database column x SqlType(DOUBLE), Default(None) */
    val x: Rep[Option[Double]] = column[Option[Double]]("x", O.Default(None))
    /** Database column y SqlType(DOUBLE), Default(None) */
    val y: Rep[Option[Double]] = column[Option[Double]]("y", O.Default(None))
    /** Database column z SqlType(DOUBLE), Default(None) */
    val z: Rep[Option[Double]] = column[Option[Double]]("z", O.Default(None))
    /** Database column reprocessingEfficiency SqlType(DOUBLE), Default(None) */
    val reprocessingefficiency: Rep[Option[Double]] = column[Option[Double]]("reprocessingEfficiency", O.Default(None))
    /** Database column reprocessingStationsTake SqlType(DOUBLE), Default(None) */
    val reprocessingstationstake: Rep[Option[Double]] = column[Option[Double]]("reprocessingStationsTake", O.Default(None))
    /** Database column reprocessingHangarFlag SqlType(TINYINT UNSIGNED), Default(None) */
    val reprocessinghangarflag: Rep[Option[Byte]] = column[Option[Byte]]("reprocessingHangarFlag", O.Default(None))

    /** Index over (constellationid) (database name staStations_IX_constellation) */
    val index1 = index("staStations_IX_constellation", constellationid)
    /** Index over (corporationid) (database name staStations_IX_corporation) */
    val index2 = index("staStations_IX_corporation", corporationid)
    /** Index over (operationid) (database name staStations_IX_operation) */
    val index3 = index("staStations_IX_operation", operationid)
    /** Index over (regionid) (database name staStations_IX_region) */
    val index4 = index("staStations_IX_region", regionid)
    /** Index over (solarsystemid) (database name staStations_IX_system) */
    val index5 = index("staStations_IX_system", solarsystemid)
    /** Index over (stationtypeid) (database name staStations_IX_type) */
    val index6 = index("staStations_IX_type", stationtypeid)
  }
  /** Collection-like TableQuery object for table Stastations */
  lazy val Stastations = new TableQuery(tag => new Stastations(tag))

  /** Entity class storing rows of table Stastationtypes
   *  @param stationtypeid Database column stationTypeID SqlType(INT), PrimaryKey
   *  @param dockentryx Database column dockEntryX SqlType(DOUBLE), Default(None)
   *  @param dockentryy Database column dockEntryY SqlType(DOUBLE), Default(None)
   *  @param dockentryz Database column dockEntryZ SqlType(DOUBLE), Default(None)
   *  @param dockorientationx Database column dockOrientationX SqlType(DOUBLE), Default(None)
   *  @param dockorientationy Database column dockOrientationY SqlType(DOUBLE), Default(None)
   *  @param dockorientationz Database column dockOrientationZ SqlType(DOUBLE), Default(None)
   *  @param operationid Database column operationID SqlType(TINYINT UNSIGNED), Default(None)
   *  @param officeslots Database column officeSlots SqlType(TINYINT UNSIGNED), Default(None)
   *  @param reprocessingefficiency Database column reprocessingEfficiency SqlType(DOUBLE), Default(None)
   *  @param conquerable Database column conquerable SqlType(BIT), Default(None) */
  case class StastationtypesRow(stationtypeid: Int, dockentryx: Option[Double] = None, dockentryy: Option[Double] = None, dockentryz: Option[Double] = None, dockorientationx: Option[Double] = None, dockorientationy: Option[Double] = None, dockorientationz: Option[Double] = None, operationid: Option[Byte] = None, officeslots: Option[Byte] = None, reprocessingefficiency: Option[Double] = None, conquerable: Option[Boolean] = None)
  /** GetResult implicit for fetching StastationtypesRow objects using plain SQL queries */
  implicit def GetResultStastationtypesRow(implicit e0: GR[Int], e1: GR[Option[Double]], e2: GR[Option[Byte]], e3: GR[Option[Boolean]]): GR[StastationtypesRow] = GR{
    prs => import prs._
    StastationtypesRow.tupled((<<[Int], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Byte], <<?[Byte], <<?[Double], <<?[Boolean]))
  }
  /** Table description of table staStationTypes. Objects of this class serve as prototypes for rows in queries. */
  class Stastationtypes(_tableTag: Tag) extends Table[StastationtypesRow](_tableTag, "staStationTypes") {
    def * = (stationtypeid, dockentryx, dockentryy, dockentryz, dockorientationx, dockorientationy, dockorientationz, operationid, officeslots, reprocessingefficiency, conquerable) <> (StastationtypesRow.tupled, StastationtypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(stationtypeid), dockentryx, dockentryy, dockentryz, dockorientationx, dockorientationy, dockorientationz, operationid, officeslots, reprocessingefficiency, conquerable).shaped.<>({r=>import r._; _1.map(_=> StastationtypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column stationTypeID SqlType(INT), PrimaryKey */
    val stationtypeid: Rep[Int] = column[Int]("stationTypeID", O.PrimaryKey)
    /** Database column dockEntryX SqlType(DOUBLE), Default(None) */
    val dockentryx: Rep[Option[Double]] = column[Option[Double]]("dockEntryX", O.Default(None))
    /** Database column dockEntryY SqlType(DOUBLE), Default(None) */
    val dockentryy: Rep[Option[Double]] = column[Option[Double]]("dockEntryY", O.Default(None))
    /** Database column dockEntryZ SqlType(DOUBLE), Default(None) */
    val dockentryz: Rep[Option[Double]] = column[Option[Double]]("dockEntryZ", O.Default(None))
    /** Database column dockOrientationX SqlType(DOUBLE), Default(None) */
    val dockorientationx: Rep[Option[Double]] = column[Option[Double]]("dockOrientationX", O.Default(None))
    /** Database column dockOrientationY SqlType(DOUBLE), Default(None) */
    val dockorientationy: Rep[Option[Double]] = column[Option[Double]]("dockOrientationY", O.Default(None))
    /** Database column dockOrientationZ SqlType(DOUBLE), Default(None) */
    val dockorientationz: Rep[Option[Double]] = column[Option[Double]]("dockOrientationZ", O.Default(None))
    /** Database column operationID SqlType(TINYINT UNSIGNED), Default(None) */
    val operationid: Rep[Option[Byte]] = column[Option[Byte]]("operationID", O.Default(None))
    /** Database column officeSlots SqlType(TINYINT UNSIGNED), Default(None) */
    val officeslots: Rep[Option[Byte]] = column[Option[Byte]]("officeSlots", O.Default(None))
    /** Database column reprocessingEfficiency SqlType(DOUBLE), Default(None) */
    val reprocessingefficiency: Rep[Option[Double]] = column[Option[Double]]("reprocessingEfficiency", O.Default(None))
    /** Database column conquerable SqlType(BIT), Default(None) */
    val conquerable: Rep[Option[Boolean]] = column[Option[Boolean]]("conquerable", O.Default(None))
  }
  /** Collection-like TableQuery object for table Stastationtypes */
  lazy val Stastationtypes = new TableQuery(tag => new Stastationtypes(tag))

  /** Entity class storing rows of table Translationtables
   *  @param sourcetable Database column sourceTable SqlType(VARCHAR), Length(200,true)
   *  @param destinationtable Database column destinationTable SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param translatedkey Database column translatedKey SqlType(VARCHAR), Length(200,true)
   *  @param tcgroupid Database column tcGroupID SqlType(INT), Default(None)
   *  @param tcid Database column tcID SqlType(INT), Default(None) */
  case class TranslationtablesRow(sourcetable: String, destinationtable: Option[String] = None, translatedkey: String, tcgroupid: Option[Int] = None, tcid: Option[Int] = None)
  /** GetResult implicit for fetching TranslationtablesRow objects using plain SQL queries */
  implicit def GetResultTranslationtablesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[TranslationtablesRow] = GR{
    prs => import prs._
    TranslationtablesRow.tupled((<<[String], <<?[String], <<[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table translationTables. Objects of this class serve as prototypes for rows in queries. */
  class Translationtables(_tableTag: Tag) extends Table[TranslationtablesRow](_tableTag, "translationTables") {
    def * = (sourcetable, destinationtable, translatedkey, tcgroupid, tcid) <> (TranslationtablesRow.tupled, TranslationtablesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(sourcetable), destinationtable, Rep.Some(translatedkey), tcgroupid, tcid).shaped.<>({r=>import r._; _1.map(_=> TranslationtablesRow.tupled((_1.get, _2, _3.get, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column sourceTable SqlType(VARCHAR), Length(200,true) */
    val sourcetable: Rep[String] = column[String]("sourceTable", O.Length(200,varying=true))
    /** Database column destinationTable SqlType(VARCHAR), Length(200,true), Default(None) */
    val destinationtable: Rep[Option[String]] = column[Option[String]]("destinationTable", O.Length(200,varying=true), O.Default(None))
    /** Database column translatedKey SqlType(VARCHAR), Length(200,true) */
    val translatedkey: Rep[String] = column[String]("translatedKey", O.Length(200,varying=true))
    /** Database column tcGroupID SqlType(INT), Default(None) */
    val tcgroupid: Rep[Option[Int]] = column[Option[Int]]("tcGroupID", O.Default(None))
    /** Database column tcID SqlType(INT), Default(None) */
    val tcid: Rep[Option[Int]] = column[Option[Int]]("tcID", O.Default(None))

    /** Primary key of Translationtables (database name translationTables_PK) */
    val pk = primaryKey("translationTables_PK", (sourcetable, translatedkey))
  }
  /** Collection-like TableQuery object for table Translationtables */
  lazy val Translationtables = new TableQuery(tag => new Translationtables(tag))

  /** Entity class storing rows of table Trntranslationcolumns
   *  @param tcgroupid Database column tcGroupID SqlType(SMALLINT), Default(None)
   *  @param tcid Database column tcID SqlType(SMALLINT), PrimaryKey
   *  @param tablename Database column tableName SqlType(VARCHAR), Length(256,true)
   *  @param columnname Database column columnName SqlType(VARCHAR), Length(128,true)
   *  @param masterid Database column masterID SqlType(VARCHAR), Length(128,true), Default(None) */
  case class TrntranslationcolumnsRow(tcgroupid: Option[Short] = None, tcid: Short, tablename: String, columnname: String, masterid: Option[String] = None)
  /** GetResult implicit for fetching TrntranslationcolumnsRow objects using plain SQL queries */
  implicit def GetResultTrntranslationcolumnsRow(implicit e0: GR[Option[Short]], e1: GR[Short], e2: GR[String], e3: GR[Option[String]]): GR[TrntranslationcolumnsRow] = GR{
    prs => import prs._
    TrntranslationcolumnsRow.tupled((<<?[Short], <<[Short], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table trnTranslationColumns. Objects of this class serve as prototypes for rows in queries. */
  class Trntranslationcolumns(_tableTag: Tag) extends Table[TrntranslationcolumnsRow](_tableTag, "trnTranslationColumns") {
    def * = (tcgroupid, tcid, tablename, columnname, masterid) <> (TrntranslationcolumnsRow.tupled, TrntranslationcolumnsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (tcgroupid, Rep.Some(tcid), Rep.Some(tablename), Rep.Some(columnname), masterid).shaped.<>({r=>import r._; _2.map(_=> TrntranslationcolumnsRow.tupled((_1, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column tcGroupID SqlType(SMALLINT), Default(None) */
    val tcgroupid: Rep[Option[Short]] = column[Option[Short]]("tcGroupID", O.Default(None))
    /** Database column tcID SqlType(SMALLINT), PrimaryKey */
    val tcid: Rep[Short] = column[Short]("tcID", O.PrimaryKey)
    /** Database column tableName SqlType(VARCHAR), Length(256,true) */
    val tablename: Rep[String] = column[String]("tableName", O.Length(256,varying=true))
    /** Database column columnName SqlType(VARCHAR), Length(128,true) */
    val columnname: Rep[String] = column[String]("columnName", O.Length(128,varying=true))
    /** Database column masterID SqlType(VARCHAR), Length(128,true), Default(None) */
    val masterid: Rep[Option[String]] = column[Option[String]]("masterID", O.Length(128,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Trntranslationcolumns */
  lazy val Trntranslationcolumns = new TableQuery(tag => new Trntranslationcolumns(tag))

  /** Entity class storing rows of table Trntranslationlanguages
   *  @param numericlanguageid Database column numericLanguageID SqlType(INT), PrimaryKey
   *  @param languageid Database column languageID SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param languagename Database column languageName SqlType(VARCHAR), Length(200,true), Default(None) */
  case class TrntranslationlanguagesRow(numericlanguageid: Int, languageid: Option[String] = None, languagename: Option[String] = None)
  /** GetResult implicit for fetching TrntranslationlanguagesRow objects using plain SQL queries */
  implicit def GetResultTrntranslationlanguagesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[TrntranslationlanguagesRow] = GR{
    prs => import prs._
    TrntranslationlanguagesRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table trnTranslationLanguages. Objects of this class serve as prototypes for rows in queries. */
  class Trntranslationlanguages(_tableTag: Tag) extends Table[TrntranslationlanguagesRow](_tableTag, "trnTranslationLanguages") {
    def * = (numericlanguageid, languageid, languagename) <> (TrntranslationlanguagesRow.tupled, TrntranslationlanguagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(numericlanguageid), languageid, languagename).shaped.<>({r=>import r._; _1.map(_=> TrntranslationlanguagesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column numericLanguageID SqlType(INT), PrimaryKey */
    val numericlanguageid: Rep[Int] = column[Int]("numericLanguageID", O.PrimaryKey)
    /** Database column languageID SqlType(VARCHAR), Length(50,true), Default(None) */
    val languageid: Rep[Option[String]] = column[Option[String]]("languageID", O.Length(50,varying=true), O.Default(None))
    /** Database column languageName SqlType(VARCHAR), Length(200,true), Default(None) */
    val languagename: Rep[Option[String]] = column[Option[String]]("languageName", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Trntranslationlanguages */
  lazy val Trntranslationlanguages = new TableQuery(tag => new Trntranslationlanguages(tag))

  /** Entity class storing rows of table Trntranslations
   *  @param tcid Database column tcID SqlType(SMALLINT)
   *  @param keyid Database column keyID SqlType(INT)
   *  @param languageid Database column languageID SqlType(VARCHAR), Length(50,true)
   *  @param text Database column text SqlType(LONGTEXT), Length(2147483647,true) */
  case class TrntranslationsRow(tcid: Short, keyid: Int, languageid: String, text: String)
  /** GetResult implicit for fetching TrntranslationsRow objects using plain SQL queries */
  implicit def GetResultTrntranslationsRow(implicit e0: GR[Short], e1: GR[Int], e2: GR[String]): GR[TrntranslationsRow] = GR{
    prs => import prs._
    TrntranslationsRow.tupled((<<[Short], <<[Int], <<[String], <<[String]))
  }
  /** Table description of table trnTranslations. Objects of this class serve as prototypes for rows in queries. */
  class Trntranslations(_tableTag: Tag) extends Table[TrntranslationsRow](_tableTag, "trnTranslations") {
    def * = (tcid, keyid, languageid, text) <> (TrntranslationsRow.tupled, TrntranslationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(tcid), Rep.Some(keyid), Rep.Some(languageid), Rep.Some(text)).shaped.<>({r=>import r._; _1.map(_=> TrntranslationsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column tcID SqlType(SMALLINT) */
    val tcid: Rep[Short] = column[Short]("tcID")
    /** Database column keyID SqlType(INT) */
    val keyid: Rep[Int] = column[Int]("keyID")
    /** Database column languageID SqlType(VARCHAR), Length(50,true) */
    val languageid: Rep[String] = column[String]("languageID", O.Length(50,varying=true))
    /** Database column text SqlType(LONGTEXT), Length(2147483647,true) */
    val text: Rep[String] = column[String]("text", O.Length(2147483647,varying=true))

    /** Primary key of Trntranslations (database name trnTranslations_PK) */
    val pk = primaryKey("trnTranslations_PK", (tcid, keyid, languageid))
  }
  /** Collection-like TableQuery object for table Trntranslations */
  lazy val Trntranslations = new TableQuery(tag => new Trntranslations(tag))

  /** Entity class storing rows of table Warcombatzones
   *  @param combatzoneid Database column combatZoneID SqlType(INT), PrimaryKey, Default(-1)
   *  @param combatzonename Database column combatZoneName SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param factionid Database column factionID SqlType(INT), Default(None)
   *  @param centersystemid Database column centerSystemID SqlType(INT), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(500,true), Default(None) */
  case class WarcombatzonesRow(combatzoneid: Int = -1, combatzonename: Option[String] = None, factionid: Option[Int] = None, centersystemid: Option[Int] = None, description: Option[String] = None)
  /** GetResult implicit for fetching WarcombatzonesRow objects using plain SQL queries */
  implicit def GetResultWarcombatzonesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[WarcombatzonesRow] = GR{
    prs => import prs._
    WarcombatzonesRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table warCombatZones. Objects of this class serve as prototypes for rows in queries. */
  class Warcombatzones(_tableTag: Tag) extends Table[WarcombatzonesRow](_tableTag, "warCombatZones") {
    def * = (combatzoneid, combatzonename, factionid, centersystemid, description) <> (WarcombatzonesRow.tupled, WarcombatzonesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(combatzoneid), combatzonename, factionid, centersystemid, description).shaped.<>({r=>import r._; _1.map(_=> WarcombatzonesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column combatZoneID SqlType(INT), PrimaryKey, Default(-1) */
    val combatzoneid: Rep[Int] = column[Int]("combatZoneID", O.PrimaryKey, O.Default(-1))
    /** Database column combatZoneName SqlType(VARCHAR), Length(100,true), Default(None) */
    val combatzonename: Rep[Option[String]] = column[Option[String]]("combatZoneName", O.Length(100,varying=true), O.Default(None))
    /** Database column factionID SqlType(INT), Default(None) */
    val factionid: Rep[Option[Int]] = column[Option[Int]]("factionID", O.Default(None))
    /** Database column centerSystemID SqlType(INT), Default(None) */
    val centersystemid: Rep[Option[Int]] = column[Option[Int]]("centerSystemID", O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(500,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Warcombatzones */
  lazy val Warcombatzones = new TableQuery(tag => new Warcombatzones(tag))

  /** Entity class storing rows of table Warcombatzonesystems
   *  @param solarsystemid Database column solarSystemID SqlType(INT), PrimaryKey
   *  @param combatzoneid Database column combatZoneID SqlType(INT), Default(None) */
  case class WarcombatzonesystemsRow(solarsystemid: Int, combatzoneid: Option[Int] = None)
  /** GetResult implicit for fetching WarcombatzonesystemsRow objects using plain SQL queries */
  implicit def GetResultWarcombatzonesystemsRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[WarcombatzonesystemsRow] = GR{
    prs => import prs._
    WarcombatzonesystemsRow.tupled((<<[Int], <<?[Int]))
  }
  /** Table description of table warCombatZoneSystems. Objects of this class serve as prototypes for rows in queries. */
  class Warcombatzonesystems(_tableTag: Tag) extends Table[WarcombatzonesystemsRow](_tableTag, "warCombatZoneSystems") {
    def * = (solarsystemid, combatzoneid) <> (WarcombatzonesystemsRow.tupled, WarcombatzonesystemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(solarsystemid), combatzoneid).shaped.<>({r=>import r._; _1.map(_=> WarcombatzonesystemsRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column solarSystemID SqlType(INT), PrimaryKey */
    val solarsystemid: Rep[Int] = column[Int]("solarSystemID", O.PrimaryKey)
    /** Database column combatZoneID SqlType(INT), Default(None) */
    val combatzoneid: Rep[Option[Int]] = column[Option[Int]]("combatZoneID", O.Default(None))
  }
  /** Collection-like TableQuery object for table Warcombatzonesystems */
  lazy val Warcombatzonesystems = new TableQuery(tag => new Warcombatzonesystems(tag))
}
