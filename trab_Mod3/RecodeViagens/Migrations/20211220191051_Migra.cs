using Microsoft.EntityFrameworkCore.Migrations;

namespace RecodeViagens.Migrations
{
    public partial class Migra : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Customer",
                columns: table => new
                {
                    id_customer = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    name = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    email = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Customer", x => x.id_customer);
                });

            migrationBuilder.CreateTable(
                name: "Transit",
                columns: table => new
                {
                    id_transit = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    origin = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    destination = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    price = table.Column<float>(type: "real", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Transit", x => x.id_transit);
                });

            migrationBuilder.CreateTable(
                name: "Travel",
                columns: table => new
                {
                    id_travel = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    customerId = table.Column<int>(type: "int", nullable: false),
                    transitId = table.Column<int>(type: "int", nullable: false),
                    promo_code = table.Column<string>(type: "nvarchar(max)", nullable: true),
                    tickets = table.Column<int>(type: "int", nullable: false),
                    status = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Travel", x => x.id_travel);
                    table.ForeignKey(
                        name: "FK_Travel_Customer_customerId",
                        column: x => x.customerId,
                        principalTable: "Customer",
                        principalColumn: "id_customer",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Travel_Transit_transitId",
                        column: x => x.transitId,
                        principalTable: "Transit",
                        principalColumn: "id_transit",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Travel_customerId",
                table: "Travel",
                column: "customerId");

            migrationBuilder.CreateIndex(
                name: "IX_Travel_transitId",
                table: "Travel",
                column: "transitId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Travel");

            migrationBuilder.DropTable(
                name: "Customer");

            migrationBuilder.DropTable(
                name: "Transit");
        }
    }
}
