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
    public class TravelsController : Controller
    {
        private readonly DataModel _context;

        public TravelsController(DataModel context)
        {
            _context = context;
        }

        // GET: Travels
        public async Task<IActionResult> Index()
        {
            var dataModel = _context.Travel.Include(t => t.Customer).Include(t => t.Transit);
            return View(await dataModel.ToListAsync());
        }

        // GET: Travels/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var travel = await _context.Travel
                .Include(t => t.Customer)
                .Include(t => t.Transit)
                .FirstOrDefaultAsync(m => m.id_travel == id);
            if (travel == null)
            {
                return NotFound();
            }

            return View(travel);
        }

        // GET: Travels/Create
        public IActionResult Create()
        {
            ViewData["customerId"] = new SelectList(_context.Customer, "id_customer", "id_customer");
            ViewData["transitId"] = new SelectList(_context.Transit, "id_transit", "id_transit");
            return View();
        }

        // POST: Travels/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("id_travel,customerId,transitId,promo_code,tickets,status")] Travel travel)
        {
            if (ModelState.IsValid)
            {
                _context.Add(travel);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            ViewData["customerId"] = new SelectList(_context.Customer, "id_customer", "id_customer", travel.customerId);
            ViewData["transitId"] = new SelectList(_context.Transit, "id_transit", "id_transit", travel.transitId);
            return View(travel);
        }

        // GET: Travels/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var travel = await _context.Travel.FindAsync(id);
            if (travel == null)
            {
                return NotFound();
            }
            ViewData["customerId"] = new SelectList(_context.Customer, "id_customer", "id_customer", travel.customerId);
            ViewData["transitId"] = new SelectList(_context.Transit, "id_transit", "id_transit", travel.transitId);
            return View(travel);
        }

        // POST: Travels/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("id_travel,customerId,transitId,promo_code,tickets,status")] Travel travel)
        {
            if (id != travel.id_travel)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(travel);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!TravelExists(travel.id_travel))
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
            ViewData["customerId"] = new SelectList(_context.Customer, "id_customer", "id_customer", travel.customerId);
            ViewData["transitId"] = new SelectList(_context.Transit, "id_transit", "id_transit", travel.transitId);
            return View(travel);
        }

        // GET: Travels/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var travel = await _context.Travel
                .Include(t => t.Customer)
                .Include(t => t.Transit)
                .FirstOrDefaultAsync(m => m.id_travel == id);
            if (travel == null)
            {
                return NotFound();
            }

            return View(travel);
        }

        // POST: Travels/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var travel = await _context.Travel.FindAsync(id);
            _context.Travel.Remove(travel);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool TravelExists(int id)
        {
            return _context.Travel.Any(e => e.id_travel == id);
        }
    }
}
