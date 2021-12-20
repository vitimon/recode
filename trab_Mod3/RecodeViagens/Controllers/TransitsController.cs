using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using RecodeViagens.Models;

namespace RecodeViagens.Controllers
{
    public class TransitsController : Controller
    {
        private readonly DataModel _context;

        public TransitsController(DataModel context)
        {
            _context = context;
        }

        // GET: Transits
        public async Task<IActionResult> Index()
        {
            return View(await _context.Transit.ToListAsync());
        }

        // GET: Transits/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var transit = await _context.Transit
                .FirstOrDefaultAsync(m => m.id_transit == id);
            if (transit == null)
            {
                return NotFound();
            }

            return View(transit);
        }

        // GET: Transits/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Transits/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("id_transit,origin,destination,price")] Transit transit)
        {
            if (ModelState.IsValid)
            {
                _context.Add(transit);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(transit);
        }

        // GET: Transits/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var transit = await _context.Transit.FindAsync(id);
            if (transit == null)
            {
                return NotFound();
            }
            return View(transit);
        }

        // POST: Transits/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("id_transit,origin,destination,price")] Transit transit)
        {
            if (id != transit.id_transit)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(transit);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!TransitExists(transit.id_transit))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(transit);
        }

        // GET: Transits/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var transit = await _context.Transit
                .FirstOrDefaultAsync(m => m.id_transit == id);
            if (transit == null)
            {
                return NotFound();
            }

            return View(transit);
        }

        // POST: Transits/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var transit = await _context.Transit.FindAsync(id);
            _context.Transit.Remove(transit);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool TransitExists(int id)
        {
            return _context.Transit.Any(e => e.id_transit == id);
        }
    }
}
