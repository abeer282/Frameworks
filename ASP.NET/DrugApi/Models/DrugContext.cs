using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using Microsoft.EntityFrameworkCore;

namespace DrugApi.Models
{
    public class DrugContext : DbContext
    {
        public DrugContext(DbContextOptions<DrugContext> options)
            : base(options)
        {
        }

        public DbSet<Drug> Drugs { get; set; }
    }
}
