using Microsoft.EntityFrameworkCore.Migrations;

namespace SQLiteASPNET.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "StudentsInfo",
                columns: table => new
                {
                    Id = table.Column<long>(nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    stuPrefix = table.Column<string>(nullable: true),
                    stuFirstName = table.Column<string>(nullable: true),
                    stuLastName = table.Column<string>(nullable: true),
                    stuGrade = table.Column<int>(nullable: false),
                    stuAge = table.Column<int>(nullable: false),
                    stuDayScholar = table.Column<string>(nullable: true),
                    stuOptionalLang = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_StudentsInfo", x => x.Id);
                });

            migrationBuilder.InsertData(
                table: "StudentsInfo",
                columns: new[] { "Id", "stuAge", "stuDayScholar", "stuFirstName", "stuGrade", "stuLastName", "stuOptionalLang", "stuPrefix" },
                values: new object[] { 1L, 11, "Yes", "Amelia", 6, "Petter", "French", "Ms." });

            migrationBuilder.InsertData(
                table: "StudentsInfo",
                columns: new[] { "Id", "stuAge", "stuDayScholar", "stuFirstName", "stuGrade", "stuLastName", "stuOptionalLang", "stuPrefix" },
                values: new object[] { 2L, 12, "No", "Richard", 7, "Grey", "Spanish", "Mr." });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "StudentsInfo");
        }
    }
}
