﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using SQLiteASPNET;

namespace SQLiteASPNET.Migrations
{
    [DbContext(typeof(DBInteractor))]
    partial class DBInteractorModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "2.1.14-servicing-32113");

            modelBuilder.Entity("SQLiteASPNET.StudentsInfo", b =>
                {
                    b.Property<long>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("stuAge");

                    b.Property<string>("stuDayScholar");

                    b.Property<string>("stuFirstName");

                    b.Property<int>("stuGrade");

                    b.Property<string>("stuLastName");

                    b.Property<string>("stuOptionalLang");

                    b.Property<string>("stuPrefix");

                    b.HasKey("Id");

                    b.ToTable("StudentsInfo");

                    b.HasData(
                        new { Id = 1L, stuAge = 11, stuDayScholar = "Yes", stuFirstName = "Amelia", stuGrade = 6, stuLastName = "Petter", stuOptionalLang = "French", stuPrefix = "Ms." },
                        new { Id = 2L, stuAge = 12, stuDayScholar = "No", stuFirstName = "Richard", stuGrade = 7, stuLastName = "Grey", stuOptionalLang = "Spanish", stuPrefix = "Mr." }
                    );
                });
#pragma warning restore 612, 618
        }
    }
}
